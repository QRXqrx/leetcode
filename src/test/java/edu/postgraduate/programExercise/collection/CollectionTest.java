package edu.postgraduate.programExercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-17
 */
public class CollectionTest {

    @Test
    public void test() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = Arrays.asList(2, 3, 5);
        System.out.println(list1);
        System.out.println(list2);

//        list1.removeAll(list2);
        list1.retainAll(list2);
        System.out.println(list1);

    }
}
