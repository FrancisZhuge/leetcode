package com.francis.leetcode.p102_levelOrder;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair<TreeNode, Integer>> record = new LinkedList<>();
        record.add(new Pair<>(root, 0));
        while (!record.isEmpty()) {
            Pair<TreeNode, Integer> pair = record.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();
            if (ans.size() == level) ans.add(new ArrayList<>());

            ans.get(level).add(node.val);
            if (node.left != null) record.add(new Pair<>(node.left, level + 1));
            if (node.right != null) record.add(new Pair<>(node.right, level + 1));
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }
}
