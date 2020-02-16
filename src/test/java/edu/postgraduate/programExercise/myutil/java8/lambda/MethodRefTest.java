package edu.postgraduate.programExercise.myutil.java8.lambda;

import edu.postgraduate.programExercise.bean.Person;
import javafx.util.converter.IntegerStringConverter;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 1.方法引用
     * 若lambda体中的内容已经有方法实现过了，可以使用方法引用的方式进行直接替换
     *  使用的前提：被引用的方法与lambda表达式要实现的函数接口中的方法的参数列表、返回值都要对应的上
     *
     * 主要有三种语法格式：
     *
     * 对象::实例方法名
     *
     * 类::静态方法名
     *
     * 类::实例方法名
     *  若lambda表达式参数表中，第一个参数是函数体中方法的调用者；另一个是方法的参数，就可以使用这种引用方式
     *
 *
 * 2.构造器引用： ClassName::new
    *  需要调用的构造器的参数列表应该与需要调用的函数式接口中的方法的参数列表一致。
 *
 * 3.数组引用：Type[]::new
 */
public class MethodRefTest {
    // 对象::实例方法名
    @Test
    public void test1() {
        Consumer con1 = (x) -> System.out.println(x); // 右边就变成了一个实现了accept方法的（实现了Consumer的）实例
        Consumer con2 = System.out::println;
        con1.accept("asdasd");
        con2.accept("asdasd");
    }

    @Test
    public void test2() {
        Person person = new Person();
        Supplier sup1 = person::getAge;
//        Supplier sup1 = person::getName;    // 可以。泛型匹配
        Supplier<String> sup2 = person::getName;
//        Supplier<String> sup3 = person::getAge; // 不可以。指定了泛型之后，类型推断判断前后文类型不匹配
    }

    // 类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compareTo;
    }

    // 类::实例方法名
    @Test
    public void test4() {
        BiPredicate<String, String> bp = (str1, str2) -> str1.equals(str2);

        BiPredicate<String, String> bp1 = String::equals;
    }

    // 构造器引用 -> 也只通过上下文类型推断，找到符合要求的构造器
    @Test
    public void test5() {
        Supplier<Person> personSupplier = () -> new Person();

        Supplier<Person> personSupplier1 = Person::new;
    }

    // 数组引用
    @Test
    public void test6() {
        Function<Integer, String[]> fun1 = (x) -> new String[x];

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs = fun2.apply(10);
        System.out.println(strs.length);
    }

}
