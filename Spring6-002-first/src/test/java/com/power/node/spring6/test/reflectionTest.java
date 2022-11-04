package com.power.node.spring6.test;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 测试反射
 * @Author darren
 * @Date 2022/11/4 10:21
 */
public class reflectionTest {

    /**
     * 反射调用方法
     *
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Test
    public void testReflectionInvokeMethod()
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        // 获取类对象
        Class<?> aClass = Class.forName("com.power.node.spring6.reflection.ReflectionClass");
        // 创建对象
        Object reflectionClass = aClass.getConstructor().newInstance();
        // 获取公示的指定方法
        Method doMethod = aClass.getDeclaredMethod("doMethod", String.class);
        // 执行方法
        doMethod.invoke(reflectionClass, "刘德华");
    }

    /**
     * 反射读取配置文件调用方法
     */
    @Test
    public void testReadTxtReflection()
            throws IOException, ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> className = Class.forName(getTxtValue("className"));

        Method methodName = className.getMethod(getTxtValue("methodName"), String.class);

        methodName.invoke(className.getConstructor().newInstance(), "张三丰");
    }

    public String getTxtValue(String key) throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(getFilePath());
        properties.load(fileReader);
        fileReader.close();
        return properties.getProperty(key);
    }

    public String getFilePath() {
        String path = this.getClass().getClassLoader().getResource("reflection.txt").getPath();
        return path;
    }


}
