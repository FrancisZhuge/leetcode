package com.francis.leetcode.p226_invertTree;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        Utils.printTree(root);
        Utils.printTree(invertTree(root));
    }
}
