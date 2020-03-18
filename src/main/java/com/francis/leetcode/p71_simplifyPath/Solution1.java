package com.francis.leetcode.p71_simplifyPath;

import org.junit.Test;

import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> record = new Stack<>();

        for (String val : split) {
            if (val.length() != 0) {
                if (".".equals(val)) continue;
                else if ("..".equals(val) && !record.empty()) record.pop();
                else if ("..".equals(val)) continue;
                else record.push(val);
            }
        }
        if (record.isEmpty()) return "/";
        String ans = "";
        while (!record.isEmpty()) ans = "/" + record.pop() + ans;
        return ans;
    }

    @Test
    public void test() {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
