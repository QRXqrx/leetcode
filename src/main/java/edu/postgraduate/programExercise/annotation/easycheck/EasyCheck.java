package edu.postgraduate.programExercise.annotation.easycheck;

import edu.postgraduate.programExercise.bean.CaculatorDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author QRX email: <a href>QRXwzx@outlook.com</a>
 * @date 2020/02/01
 *
 *  利用注解机制，编写一个自动化测试框架，实现以下功能
 *  1.自动执行带注解 @Check 的方法
 *  2.记录有多少个产生异常的方法（异常总数）
 *  3.记录每个异常的具体信息
 *  这个EasyCheck程序，其实就是一个“解析程序”。注解如果不和解析程序共同使用将毫无意义
 */
public class EasyCheck {

//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {
//        // 1.获取目标类（要自动化测试的类）下的所有方法
//        Class targetClass = Class.forName("edu.postgraduate.programExercise.bean.CaculatorDemo");
//        Method[] methods = targetClass.getMethods();
//
//        // 2.执行所有被@Check标注的方法
//        CaculatorDemo caculator = (CaculatorDemo) targetClass.newInstance();
//        int exceptionCnt = 0; // 异常计数器
//        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("easycheck_bugReport.txt")));
//        for (Method method : methods) {
//            // 如果被@Check标注了，就执行
//            if(method.isAnnotationPresent(Check.class)) {
//                // 3.执行方法
//                try { // 正常方法正常执行
//                    method.invoke(caculator);
//                } catch (Exception e) { // 捕获所有异常，记录到文件中。
//                    // 4.异常计数
//                    exceptionCnt++;
//                    // 5.书写异常信息
//                    writer.write(method.getName() + "方法出现了异常");
//                    writer.newLine();
//                    writer.write("异常类型: " + e.getCause().getClass().getSimpleName()); // Cause也是一种异常呀
//                    writer.newLine();
//                    writer.write("异常原因: " + e.getCause().getMessage());
//                    writer.newLine();
//                    writer.write("------------------------------");
//                    writer.newLine();
//                }
//            }
//        }
//        writer.write("本次自动检测一共出现了" + exceptionCnt + "次异常");
//        writer.newLine();
//        writer.write("*******************************************");
//        writer.flush();
//    }
    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        Class targetClass = Class.forName("edu.postgraduate.programExercise.bean.CaculatorDemo");
        Method[] methods = targetClass.getMethods();

        int cnt = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("easycheck_bugReport.txt")));
        CaculatorDemo caculator = (CaculatorDemo) targetClass.newInstance();
        for (Method method : methods) {
            /*
                不加这句话可能出现的问题
                    1.不符合需求
                    2.getMethods会获取所有的方法，包括父类中定义的（公共）方法。这些方法执行的时候会有问题。对于这题来说，这个问题是这个额
                    外方法可能有参(?存疑)
              */
            if(method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(caculator);
                } catch (Exception e) {
                    cnt++;
                    writer.write(method.getName() + "方法在执行中出现异常");
                    writer.newLine();
                    writer.write("异常名称: " + e.getCause().getClass().getSimpleName());
                    writer.newLine();
                    writer.write("异常原因: " + e.getCause().getMessage());
                    writer.newLine();
                    writer.write("----------------------------------");
                    writer.newLine();
                }
            }
        }
        writer.write("本次自动化测试一共出现" + cnt + "次异常");
        writer.newLine();
        writer.write("*******************************************");
        writer.flush();
    }
}
