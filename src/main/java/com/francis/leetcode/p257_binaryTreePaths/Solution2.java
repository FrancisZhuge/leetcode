package com.francis.leetcode.p257_binaryTreePaths;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, ""));
        while (!queue.isEmpty()) {
            Pair<TreeNode, String> pair = queue.poll();
            TreeNode node = pair.getKey();
            String path = pair.getValue() + node.val;
            if (node.left == null && node.right == null) ans.add(path);
            path += "->";
            if (node.left != null) queue.add(new Pair<>(node.left, path));
            if (node.right != null) queue.add(new Pair<>(node.right, path));
        }
        return ans;
    }


    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 3, null, 5});
        Utils.printTree(root);
        System.out.println(binaryTreePaths(root));
    }
}
