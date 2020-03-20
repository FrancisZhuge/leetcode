package com.francis.leetcode.p110_isBalanced;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(node.right);
        if (rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) < 2 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        System.out.println(isBalanced(root));
    }
}
