package com.francis.leetcode.p101_isSymmetric;

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(root.left, root.right));
        while (!queue.isEmpty()) {
            Pair<TreeNode, TreeNode> pair = queue.poll();
            TreeNode node1 = pair.getKey();
            TreeNode node2 = pair.getValue();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.add(new Pair<>(node1.left, node2.right));
            queue.add(new Pair<>(node1.right, node2.left));
        }
        return true;
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
