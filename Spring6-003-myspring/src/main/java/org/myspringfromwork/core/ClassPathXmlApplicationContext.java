package org.myspringfromwork.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.myspringfromwork.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Author darren
 * @Date 2022/11/4 16:05
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{

    private static final Logger logger =
            LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String,Object> singletonObjects = new HashMap<>();

    public ClassPathXmlApplicationContext(String configLocation) {

        // 1:读取文件
        Document document = getFileDocument(configLocation);

        // 2:创建Bean 并加入Map
        doCreateBean(document);

        // 3:给属性赋值
        setPropertyValue(document);
    }

    /**
     * 1:读取文件
     * @param configLocation 文件名称
     * @return Document
     */
    private Document getFileDocument(final String configLocation) {
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(
                configLocation);

        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(resourceAsStream);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return document;
    }

    /**
     * 2：创建Bean 并加入Map
     * @param document
     */
    private void doCreateBean(final Document document) {
        List<Node> nodes = document.selectNodes("//bean");

        nodes.forEach(node -> {
            Element element = (Element) node;
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");
            Class<?> aClass;
            try {
                aClass = Class.forName(className);
                Object obj = aClass.getConstructor().newInstance();
                singletonObjects.put(id, obj);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 3:给属性赋值
     * @param document document
     */
    private void setPropertyValue(final Document document) {
        List<Node> nodes = document.selectNodes("//bean");

        // 获取节点ID
        // 得到对象
        // 获取节点的属性
        // 遍历属性拿到属性名称和值
        nodes.stream().map(node -> (Element) node).forEach(element -> {
            String id = element.attributeValue("id");
            Object o = singletonObjects.get(id);
            List<Element> propertys = element.elements("property");
            propertys.forEach(property -> {
                // 获取属性名
                String name = property.attributeValue("name");
                // 获取属性值
                String value = property.attributeValue("value");
                String ref = property.attributeValue("ref");

                //获取属性类型
                Class<?> type;
                try {
                    type = o.getClass().getDeclaredField(name).getType();
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }

                // 获取set方法名称
                String setMethod = StringUtil.becomeSetMethod(name);
                // 给bean 设置值
                try {
                    Method declaredMethod = o.getClass().getDeclaredMethod(setMethod, type);
                    if (value != null) {
                        // value 要转成合适的类型
                        declaredMethod.invoke(o, StringUtil.typeConversion(value, type));
                    }
                    if (ref != null) {
                        declaredMethod.invoke(o,singletonObjects.get(ref));
                    }
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }


            });
        });
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
