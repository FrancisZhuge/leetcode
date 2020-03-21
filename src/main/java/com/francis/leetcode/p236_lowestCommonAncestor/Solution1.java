package com.francis.leetcode.p236_lowestCommonAncestor;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return right;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Utils.printTree(root);
    }
}
