package edu.postgraduate.generic;

import edu.postgraduate.programExercise.bean.Person;
import edu.postgraduate.programExercise.bean.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-19
 */
public class GenericTest {


    @Test
    public void test1() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5; extends -> ≤

//        list2 = list3; super -> ≥
        list2 = list4;
        list2 = list5;

        list1 = list3;
//        list1.add(new Student()); -> 不可以
//        list1.add(new Person()); -> 不可以
//        list1.add(new Object()); -> 不可以 理解：没有兜底的值，就不知道这个对象是提供给多小的类使用的。万一加入的对象比较大，则会出现错误。

        list2 = list4;
        list2.add(new Person());
        list2.add(new Student());

    }

    private <E> List<E> fromArrToList(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    @Test
    public void test0() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 1, 3, 2};
        System.out.println(fromArrToList(arr));
    }
}
