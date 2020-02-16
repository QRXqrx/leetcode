package edu.postgraduate.programExercise.myutil;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class MySortUtilTest {

//    private String dumpArr(int[] arr) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("[");
//        for(int i = 0 ;i < arr.length ; i++) {
//            builder.append(String.valueOf(arr[i]));
//            if(i != arr.length - 1) {
//                builder.append("\t");
//            }
//        }
//        builder.append("]");
//        return builder.toString();
//    }

    @Test
    public void testQuickSort() {

    }

    @Test
    public void testQuickSort2() {
        int[] arr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        int[] sortedArr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        Arrays.sort(sortedArr);
        MySortUtil.quickSort(arr);
        Assert.assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }

    @Test
    public void testQuickSort1() {
        int[] arr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        System.out.println("Before:\t" + Arrays.toString(arr));
        MySortUtil.quickSort(arr);
        System.out.println("After:\t" + Arrays.toString(arr));
    }

    @Test
    public void testQuickSort0() {
        int[] arr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        System.out.println("Before:\t" + Arrays.toString(arr));
        MySortUtil.quickSort(0, 5, arr);
        System.out.println("After:\t" + Arrays.toString(arr));
    }

    @Test
    public void testBubbleSort() {
        int[] arr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        int[] sortedArr = new int[]{9, 193, 12, -12, -3, -2, -43, 9, 12, 1, 24, 123};
        Arrays.sort(sortedArr);
        MySortUtil.bubbleSort(arr);
        Assert.assertEquals(Arrays.toString(sortedArr), Arrays.toString(arr));
    }



}
