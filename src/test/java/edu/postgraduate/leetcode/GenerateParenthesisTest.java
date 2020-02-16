package edu.postgraduate.leetcode;

import edu.postgraduate.leetcode.Solution;
import org.junit.Test;

import java.util.List;

public class GenerateParenthesisTest {
    private void test(int n) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(n);

        for(String parentheses: result) {
            System.out.println(parentheses);
        }
    }

    @Test
    public void test1() {
        test(3);
    }
    @Test
    public void test2() {
        test(1);
    }
}
