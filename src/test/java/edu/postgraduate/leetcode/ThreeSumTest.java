package edu.postgraduate.leetcode;

import edu.postgraduate.leetcode.Solution;
import org.junit.Test;

import java.util.List;

public class ThreeSumTest {

    private void dumpList(List<List<Integer>> list) {
        if(list == null) {
            System.out.println("null");
        } else {
            for(List<Integer> triple : list) {
                System.out.println(triple);
            }
        }
        System.out.println("----------------------");
    }

    @Test
    public void test0() {
        Solution s = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> tripleList = s.threeSum(nums);
        dumpList(tripleList);
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        int[] nums = {};
        List<List<Integer>> tripleList = s.threeSum(nums);
        dumpList(tripleList);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        int[] nums = {-1, 0, 1, 0};
        List<List<Integer>> tripleList = s.threeSum(nums);
        dumpList(tripleList);
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> tripleList = s.threeSum(nums);
        dumpList(tripleList);
    }

}
