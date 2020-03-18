package com.francis.leetcode.p150_evalRPN;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> record = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int val1 = record.pop();
                int val2 = record.pop();
                record.push(val2 + val1);
            } else if (token.equals("-")) {
                int val1 = record.pop();
                int val2 = record.pop();
                record.push(val2 - val1);
            } else if (token.equals("*")) {
                int val1 = record.pop();
                int val2 = record.pop();
                record.push(val2 * val1);
            } else if (token.equals("/")) {
                int val1 = record.pop();
                int val2 = record.pop();
                record.push(val2 / val1);
            } else
                record.push(Integer.valueOf(token));
        }
        return record.pop();
    }

    @Test
    public void test() {
        String[] tokens_1 = {"2", "1", "+", "3", "*"};
        System.out.println(Arrays.toString(tokens_1));
        System.out.println(evalRPN(tokens_1));

        String[] tokens_2 = {"4", "13", "5", "/", "+"};
        System.out.println(Arrays.toString(tokens_2));
        System.out.println(evalRPN(tokens_2));

        String[] tokens_3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(Arrays.toString(tokens_3));
        System.out.println(evalRPN(tokens_3));
    }
}
