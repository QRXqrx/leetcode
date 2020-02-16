package edu.postgraduate.leetcode;

import edu.postgraduate.leetcode.Solution;
import org.junit.Assert;
import org.junit.Test;

public class IntToRomanTest {

    private void test(int num, String expectedRoman) {
        Solution s = new Solution();
        String roman = s.intToRoman(num);
        Assert.assertEquals(expectedRoman, roman);
    }

    @Test
    public void test1() {
        test(3, "III");
    }

    @Test
    public void test2() {
        test(4, "IV");
    }

    @Test
    public void test3() {
        test(9, "IX");
    }

    @Test
    public void test4() {
        test(58, "LVIII");
    }

    @Test
    public void test5() {
        test(1994, "MCMXCIV");
    }

    @Test
    public void test6() {
        test(40, "XL");
    }

    @Test
    public void test7() {
        test(90, "XC");
    }

    @Test
    public void test8() {
        test(400, "CD");
    }

    @Test
    public void test9() {
        test(900, "CM");
    }
}
