package com.francis.leetcode.p450_deleteNode;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.left == null) {
            TreeNode right = root.right;
            root.right = null;
            return right;
        }
        if (root.right == null) {
            TreeNode left = root.left;
            root.left = null;
            return left;
        }
        TreeNode node = new TreeNode(min(root.right));
        root.right = removeMin(root.right);
        node.left = root.left;
        node.right = root.right;
        return node;
    }

    private int min(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.val;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        Utils.printTree(root);
        TreeNode node = deleteNode(root, 3);
        Utils.printTree(node);
    }
}
