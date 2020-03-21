package com.francis.leetcode.p112_hasPathSum;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, sum));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer value = pair.getValue();
            if (node.val == value && node.left == null && node.right == null) return true;
            if (node.left != null) queue.add(new Pair<>(node.left, value - node.val));
            if (node.right != null) queue.add(new Pair<>(node.right, value - node.val));
        }
        return false;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});
        Utils.printTree(root);
        System.out.println(hasPathSum(root, 22));
    }
}
