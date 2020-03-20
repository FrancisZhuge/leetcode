package com.francis.leetcode.p101_isSymmetric;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        Utils.printTree(root);
        System.out.println(isSymmetric(root));


        root = Utils.createTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        Utils.printTree(root);
        System.out.println(isSymmetric(root));
    }
}
