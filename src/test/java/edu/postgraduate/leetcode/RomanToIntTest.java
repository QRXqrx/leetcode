package edu.postgraduate.leetcode;

import edu.postgraduate.leetcode.Solution;
import org.junit.Assert;
import org.junit.Test;

public class RomanToIntTest {

    private void test(String romanStr, int expected) {
        Solution s = new Solution();
        Assert.assertEquals(expected, s.romanToInt(romanStr));
    }

    @Test
    public void test1() {
        test("III", 3);
    }

    @Test
    public void test2() {
        test("IV", 4);
    }

    @Test
    public void test3() {
        test("IX", 9);
    }

    @Test
    public void test4() {
        test("LVIII", 58);
    }

    @Test
    public void test5() {
        test("MCMXCIV", 1994);
    }

//    @Test
//    public void test6() {
//        test("", );
//    }
//    @Test
//    public void test7() {
//        test("", );
//    }
//    @Test
//    public void test8() {
//        test("", );
//    }
//    @Test
//    public void test9() {
//        test("", );
//    }

}
