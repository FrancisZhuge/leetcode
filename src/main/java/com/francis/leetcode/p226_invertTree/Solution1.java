package com.francis.leetcode.p226_invertTree;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        Utils.printTree(root);
        Utils.printTree(invertTree(root));
    }
}
