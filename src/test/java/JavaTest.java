import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class JavaTest {
    // Try array
    @Test
    public void test0() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("arr1:" + arr1);
        System.out.println("arr2:" + arr2);
        if(arr1 == arr2) {
            System.out.println("Yes");
        }
        if(Arrays.equals(arr1, arr2)) {
            System.out.println("Very yes!");
        }
    }
    // Try list
    @Test
    public void test1() {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add(1);
        l2.add(2);
        l2.add(3);

        if(l1 == l2) {
            System.out.println("Yes");
        }
        if(l1.equals(l2)) {
            System.out.println("Very yes!");
        }

        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        if(!ll.contains(l2)) {
            ll.add(l2);
        }
        for(List<Integer> l : ll) {
            System.out.println(l);
        }
    }

    // Try output stream.
    @Test
    public void test2() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.out.println("os.toString(): " + os.toString());

        System.setOut(ps);
        ps.flush();
        assertTrue(os.toString().trim().contains("-6"));
        assertTrue(os.toString().trim().contains("0000001010"));
    }

    /**
     *  Test Arrays
     *  java.util.Arrays是用来操作数组的类，包含了用于操作数组的（比如排序和搜索）的各种方法
     */
    @Test
    public void testArrays1() {
        // Arrays.equals: 比较两个数组的内容是否相等。注意与“==”区分开来
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3};

        if(arr1 == arr2) {
            System.out.println("== yes!");
        } else {
            System.out.println("== no!");
        }

        if(Arrays.equals(arr1, arr2)) {
            System.out.println("Arrays.equals yes!");
        } else {
            System.out.println("Arrays.equals no!");
        }

        int[] arr3 = arr1;
        if(arr3 == arr1) {
            System.out.println("==用来检验两个数组引用是否指向同一个空间！");
        }
    }

    @Test
    public void testArrays2() {
        // Arrays.toString: 用于输出数组的内容
        int[] arr = new int[]{4, 1, 9, 2, 3, 8, 7, 5, 0, 1, 2, 9, 3, 8, 4, 0, 2, 9};
        System.out.println("直接输出的是hash值:" + arr.toString());
        System.out.println("Arrays.toString输出：" + Arrays.toString(arr));
    }

    @Test
    public void testArrays3() {
        // Arrays.fill: 将数组中的所有元素全部/指定区间的元素赋上同一个值
        int[] arr = new int[]{4, 1, 9, 2, 3, 8, 7, 5, 2, 1, 2, 9, 3, 8, 4, 3, 2, 9};
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr, 2, 8, 0);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testArrays4() {
        // Arrays.sort: 对数组(的指定区间)进行快排。需要自定义排序格式时，可以传入自定义的比较函数。
        int[] arr = new int[]{4, 1, 9, 2, 3, 8, 7, 5, 2, 1, 2, 9, 3, 8, 4, 3, 2, 9};
        System.out.println("Before sort: " + Arrays.toString(arr));
        Arrays.sort(arr, 2, 8);
        System.out.println("Partial sort: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Total sort: " + Arrays.toString(arr));
    }

    @Test
    public void testArrays5() {
        // Arrays.binarySearch: 对有序数组进行
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Result of binarySearch: " + Arrays.binarySearch(arr, 5));
        System.out.println("Don't find: " + Arrays.binarySearch(arr, -1));
    }

    /**
     *  测试JDK 5.0提供的可变个数形参功能
     */
    private void printVarargs(String ... strs) {
        if(strs == null) {
            System.out.println("Null input.");
            return;
        }
        System.out.println("Print " + strs.length + " args.");
        System.out.print("[");
        for(String str : strs) {
            System.out.print(str + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void testVarargs() {
        printVarargs();
        printVarargs("AA");
        printVarargs("AA", "BB");
        printVarargs("AA", "BB", "CC");
        printVarargs(new String[]{"AA", "BB", "CC"});
        printVarargs(null);
    }

    private void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    private void swap(Integer i, Integer j) {
        int temp = i;
        i = j;
        j = temp;
    }

    @Test
    public void swapTest1() {
        int i = 1, j = 2;
        System.out.println("i = " + i + ", j = " + j);
        swap(i, j);
        System.out.println("i = " + i + ", j = " + j);
        swap((Integer) i, (Integer) j);
        System.out.println("i = " + i + ", j = " + j);
    }

    @Test
    public void swapTest2() {
        Integer ii = 3, jj = 4;
        System.out.println("ii = " + ii + ", jj = " + jj);
        swap(ii, jj);
        System.out.println("ii = " + ii + ", jj = " + jj);
    }

    @Test
    public void printlnTest() {
        int[] arr1 = {1, 2, 3};
        System.out.println(arr1);// 地址
        char[] arr2 = {'a', 'b', 'c'};
        System.out.println(arr2);// abc
    }
}
