package com.francis.leetcode.p129_sumNumbers;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return ans;
        sumNumbers(root, 0);
        return ans;
    }

    private void sumNumbers(TreeNode node, int value) {
        value = value * 10 + node.val;
        if (node.left == null && node.right == null) ans += value;
        else {
            if (node.left != null) sumNumbers(node.left, value);
            if (node.right != null) sumNumbers(node.right, value);
        }
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{4, 9, 0, 5, 1});
        Utils.printTree(root);
        System.out.println(sumNumbers(root));

        ans = 0;
        root = Utils.createTree(new Integer[]{1, 2, 3});
        Utils.printTree(root);
        System.out.println(sumNumbers(root));
    }
}
