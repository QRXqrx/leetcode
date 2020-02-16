package edu.postgraduate.programExercise.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @Date 2020/02/01
 *
 *  使用反射机制，构建一个简单的“框架”。
 *  需求：仅修改配置文件，就可以使这个程序执行对应类中的对应无参方法。
 *  现在定义一个注解，替代配置文件，来实现这个简单“框架”
 */

@PropertiesAnno(
        packageName = "edu.postgraduate.programExercise.bean",
        className = "Student",
        methodName = "study"
)
public class FrameAnnotationDemo {

    static final String DOT = ".";

    public static void main(String[] args) throws Exception {
        // 1.获取目标注解标注位置的类型（类、方法、变量）
        Class annotatedClass = Class.forName("edu.postgraduate.programExercise.annotation.FrameAnnotationDemo");
        // 2.解析类，获得注解实例
        PropertiesAnno proAnn = (PropertiesAnno) annotatedClass.getAnnotation(PropertiesAnno.class);
        // 3.调用变量（抽象方法），获取配置值
        String packageName = proAnn.packageName();
        String className = proAnn.className();
        String methodName = proAnn.methodName();

        // 之后就和用配置文件一样了
        String fullClassName = packageName + DOT + className;

        Class clazz = Class.forName(fullClassName);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(obj);
    }
}
