package com.francis.leetcode.p100_isSameTree;

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(p, q));
        while (!queue.isEmpty()) {
            Pair<TreeNode, TreeNode> pair = queue.poll();
            TreeNode node1 = pair.getKey();
            TreeNode node2 = pair.getValue();
            if (node1 == null && node2 == null) continue;
            if (node1 == null) return false;
            if (node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(new Pair<>(node1.left, node2.left));
            queue.add(new Pair<>(node1.right, node2.right));
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode root_1 = Utils.createTree(new Integer[]{1, 2, 3});
        TreeNode root_2 = Utils.createTree(new Integer[]{1, 2, 3});
        System.out.println(isSameTree(root_1, root_2));

        root_1 = Utils.createTree(new Integer[]{1, 2});
        root_2 = Utils.createTree(new Integer[]{1, null, 2});
        System.out.println(isSameTree(root_1, root_2));

        root_1 = Utils.createTree(new Integer[]{1, 2, 1});
        root_2 = Utils.createTree(new Integer[]{1, 1, 2});
        System.out.println(isSameTree(root_1, root_2));
    }
}
