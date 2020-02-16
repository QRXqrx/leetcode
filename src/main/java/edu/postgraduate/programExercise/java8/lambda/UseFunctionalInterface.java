package edu.postgraduate.programExercise.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  java8内置的四种函数式接口
 *
 *  1.Consumer<T> : 消费型接口
 *      void accept(T t);   ---> 有去无回型，被消费了
 *  2.Supplier<T> : 供给型接口
 *      T get();    ---> 用于获取指定的变量
 *  3.Function<T, R> : 函数型接口
 *      R apply(T t);   ---> 输入映射到输出，和函数一样
 *  4.Predicate<T> : 谓词型接口
 *      boolean test(T t);  ---> 用于辅助类型T实例的一些判断
 *
 */
public class UseFunctionalInterface {

    // 消费型接口
    public void happy(double m, Consumer<Double> consumer) {
        consumer.accept(m);
    }

    // 供给型接口。需求：产生指定个数的数字，放入集合中
    public List<Integer> getNumList(int len, Supplier<Integer> supplier) {
        ArrayList<Integer> numList = new ArrayList<>();

        for(int i = 0 ; i < len ; i++) {
            numList.add(supplier.get());
        }
        return numList;
    }

    // 函数型接口。需求：依照某种方式处理字符串。
    public String handleStrWithFun(String str, Function<String, String> function) {
        return function.apply(str);
    }

    // 谓词型接口。需求：过滤出符合条件的字符串
    public List<String> filterStr(List<String> stringList, Predicate<String> predicate) {
        ArrayList<String> resultStr = new ArrayList<>();

        for (String str : stringList) {
            if(predicate.test(str)) {
                resultStr.add(str);
            }
        }

        return resultStr;
    }
}
