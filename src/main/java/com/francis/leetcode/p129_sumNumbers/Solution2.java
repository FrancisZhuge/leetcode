package com.francis.leetcode.p129_sumNumbers;

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

    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, root.val));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            Integer value = pair.getValue();
            if (node.left == null && node.right == null) ans += value;
            else {
                if (node.left != null) queue.add(new Pair<>(node.left, 10 * value + node.left.val));
                if (node.right != null) queue.add(new Pair<>(node.right, 10 * value + node.right.val));
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{4, 9, 0, 5, 1});
        Utils.printTree(root);
        System.out.println(sumNumbers(root));

        root = Utils.createTree(new Integer[]{1, 2, 3});
        Utils.printTree(root);
        System.out.println(sumNumbers(root));
    }
}
