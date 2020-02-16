package edu.postgraduate.programExercise.myutil.java8.lambda;


import edu.postgraduate.programExercise.java8.lambda.UseFunctionalInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceTest {

    private UseFunctionalInterface funIn;

    @Before
    public void init() {
        funIn = new UseFunctionalInterface();
    }


    @Test
    public void testPredicate() {
        List<String> strList = Arrays.asList("QRX", "xx", "QRX love xx", "heu", "alskjdqlQWE", "asdas", "QWEQ");

        // 过滤出长度小于5的字符串
        List<String> listAfterFilter1 = funIn.filterStr(strList, (str) -> str.length() < 5);
        for (String str : listAfterFilter1) {
            System.out.println(str);
        }
        System.out.println("-----------------");

        // 过滤出含空格的字符串
        List<String> listAfterFilter2 = funIn.filterStr(strList, (str) -> str.contains(" "));
        for (String str : listAfterFilter2) {
            System.out.println(str);
        }

    }

    @Test
    public void testFunction() {
        // 去除空格
        String string1 = "影  流  之  主";
        System.out.println("Before handle: " + string1);
        string1 = funIn.handleStrWithFun(string1, (str) -> str.replace(" ", ""));
//        string = funIn.handleStrWithFun(string, String::trim);
        System.out.println("After handle: " + string1);

        // 小写串变成大写
        String string2 = "asdjlkcASFxczsf";
        System.out.println("Before handle: " + string2);
//        string2 = funIn.handleStrWithFun(string2, (str) -> str.toUpperCase());
        string2 = funIn.handleStrWithFun(string2, String::toUpperCase);
        System.out.println("After handle: " + string2);
    }

    @Test
    public void testSupplier() {
        // 获取10个100以内的随机偶数
        List<Integer> evenList = funIn.getNumList(10, () -> {
            int num = 1;
            while(num % 2 != 0) {
                num = (int)(Math.random() * 100);
            }
            return num;
        });

        for (Integer evenNum : evenList) {
            System.out.print(evenNum + " ");
        }
        System.out.println();

        // 获取5个200以内的随机整数
        System.out.println("--------------------------");
        List<Integer> randomList = funIn.getNumList(5, () -> (int)(Math.random()*200));
        randomList.forEach(System.out::println);
    }

    @Test
    public void testConsumer() {
        funIn.happy(1000, (m) -> System.out.println("买飞机票是一种消费，每次消费" + m + "元"));
        funIn.happy(500, (m) -> System.out.println("喝酒是一种消费，每次消费"+ m +"元"));
    }
}
