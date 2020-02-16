package edu.postgraduate.programExercise.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @Date 2020/02/01
 *
 *  使用反射机制，构建一个简单的“框架”。
 *  需求：仅修改配置文件，就可以使这个程序执行对应类中的对应无参方法。
 */
public class FrameDemo {

//    public static void main(String[] args) throws Exception {
//
//        // 初始化属性值
//        PropertiesAnno properties = new PropertiesAnno();
//        // 获取用于加载属性的ClassLoader
//        ClassLoader classLoader = FrameDemo.class.getClassLoader();
//        // 将配置文件中的数据加载进内存
//        InputStream is = classLoader.getResourceAsStream("frameproperties.properties");
//        properties.load(is);
//
//        // 获取对应的方法
//        String className = properties.getProperty("class_name");
//        String methodName = properties.getProperty("method_name");
//
//        // 加载类，执行类
//        Class clazz = Class.forName(className);
//        // 空参构造对象
//        Object object = clazz.newInstance();
//        // 获取方法
//        Method method = clazz.getMethod(methodName);
//        // 执行方法
//        method.invoke(object);
//    }

    final static String DOT = ".";

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = FrameDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("frameproperties.properties");
        Properties properties = new Properties();
        properties.load(is);
        String fullClassName = properties.getProperty("package_name") + DOT + properties.getProperty("class_name");
        String methodName = properties.getProperty("method_name");
        Class clazz = Class.forName(fullClassName);
        Method method = clazz.getMethod(methodName);
        Object object = clazz.newInstance();
        method.invoke(object);
    }
}
