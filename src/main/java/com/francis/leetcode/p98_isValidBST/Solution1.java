package com.francis.leetcode.p98_isValidBST;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null) return root.val < min(root.right) && isValidBST(root.right);
        if (root.right == null) return root.val > max(root.left) && isValidBST(root.left);
        return root.val < min(root.right) && isValidBST(root.right) && root.val > max(root.left) && isValidBST(root.left);
    }

    private int min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.val;
    }

    private int max(TreeNode node) {
        while (node.right != null) node = node.right;
        return node.val;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        Utils.printTree(root);
        System.out.println(isValidBST(root));

        root = Utils.createTree(new Integer[]{2, 1, 3});
        Utils.printTree(root);
        System.out.println(isValidBST(root));
    }
}
