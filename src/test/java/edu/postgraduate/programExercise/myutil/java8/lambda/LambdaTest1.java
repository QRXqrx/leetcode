package edu.postgraduate.programExercise.myutil.java8.lambda;

import edu.postgraduate.programExercise.java8.lambda.myinterface.MyFun;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 *   1.Lambda 表达式的参数列表 ->  Lambda 表达式需要执行的功能，即Lambda体
 *   2.Lambda 就是对接口的实现。从这个层面上来看，Lambda 表达式的左边是抽象函数的参数表；右边是抽象函数的实现
 *   3.函数式接口：只有一个抽象函数的接口
 *      可以用@FunctionalInterface注解检查一下，检查是不是函数式接口
 *
 *   语法格式
 *      1.无参数，无返回值
 *          () -> System.out.println("Hello lambda");
 *      2.一个参数，无返回值
 *          (x) -> System.out.println("Value of x: " + x);
 *      3.若一个参数，参数的小括号可以省略不写
 *          x -> System.out.println("Value of x: " + x) （习惯上还是写上）
 *      4.两（多）个参数，Lambda体中有多条语句，有返回值
 *          Comparator<Integer> com = (x, y) -> {
 *             System.out.println("Comparable with two parameter: " + x + ", " + y);
 *             return Integer.compare(x, y);
 *         };
 *      5.若Lambda体中只有一条语句，大括号和return都可以省略
 *          Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 *      6.Lambda表达式的参数可以不写（要写就全写），因为JVM编译器可以根据上下文推断参数类型，即“类型推断”
 *          Comparator<Integer> com1 = (Integer x, Integer y) -> Integer.compare(x, y);
 **/


public class LambdaTest1 {

    @Test
    public void test1() {

        int num = 0; // 局部内部类，局部变量。在jdk1.7之前，必须是final；jdk1.8不需要申明，但是本质上还是final类型
//        final int num = 0; // 局部内部类，局部变量。在jdk1.7之前，必须是final；jdk1.8不需要申明，但是本质上还是final类型

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable." + num);  // 可用写法
//                System.out.println("Hello Runnable." + num++); // 错误写法
            }
        };
        r.run();

        System.out.println("-------------------------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda." + num); // 可用写法
//        Runnable r1 = () -> System.out.println("Hello Lambda." + num++); // 错误写法
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println("Value of x: " + x);
        con.accept("Hello Lambda with one parameter x.");

        Consumer<String> con1 = x -> System.out.println("Value of x: " + x);
        con1.accept("x without parentheses");
    }


    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("Comparable with two parameter: " + x + ", " + y);
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(1, 2));
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(1, 2));

        Comparator<Integer> com1 = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    /**
     * 需求：对一个数执行不同的操作
     */

    private int operation(int x, MyFun mf) {
        return mf.getValue(x);
    }
    @Test
    public void test5() {
        int num1 = operation(100, (x) -> x*x);
        int num2 = operation(100, (x) -> x/2);
        int num3 = operation(100, (x) -> x-90);
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);
    }


}