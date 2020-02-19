package edu.postgraduate.programExercise.collection;

import java.util.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-19
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < 5 ; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
//        Collections.sort(list, comparator);
        list.sort(comparator);
        System.out.println(list);
    }
}
