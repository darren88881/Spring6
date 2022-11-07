package org.myspringfromwork.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
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

    public ClassPathXmlApplicationContext(String configLocation) throws DocumentException {
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(
                configLocation);

        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(resourceAsStream);
        List<Node> nodes = document.selectNodes("//bean");

        nodes.forEach(node -> {
            Element element = (Element) node;
            String id = element.attributeValue("id");
            String aClass = element.attributeValue("class");
            logger.info("id:" + id);
            logger.info("aClass:" + aClass);

            try {
                Class<?> aClass1 = Class.forName(aClass);
                Object o = aClass1.getConstructor().newInstance();

                singletonObjects.put(id, o);

                logger.info(singletonObjects.toString());
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

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
