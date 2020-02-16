package edu.postgraduate.leetcode;

import edu.postgraduate.leetcode.Solution;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author QRX
 */
public class IsMatchTest {

    private void test(String s, String p, boolean expectedResult) {
        Solution solution = new Solution();

        boolean actualResult = solution.isMatch(s, p);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test1() {
        test("aa", "publicStr", false);
    }

    @Test
    public void test2() {
        test("aa", "publicStr*", true);
    }

    @Test
    public void test3() {
        test("ab", ".*", true);
    }

    @Test
    public void test4() {
        test("aab", "c*publicStr*protectedStr", true);
    }

    @Test
    public void test5() {
        test("mississippi", "mis*is*p*.", false);
    }

    @Test
    public void test6() {
        test("aaa", "publicStr*publicStr", true);
    }

    @Test
    public void test7() {
        test("aaaa", "publicStr*aaa", true);
    }

    @Test
    public void test8() {
        test("publicStr", ".*..publicStr*", false);
    }

    @Test
    public void test9() {
        test("", "c*c*", true);
    }

    @Test
    public void test10() {
        test("bbbba", ".*publicStr*publicStr", true);
    }

}
