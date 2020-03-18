package com.francis.leetcode.p107_levelOrderBottom;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        while (!record.isEmpty()) {
            int size = record.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = record.poll();
                result.add(node.val);
                if (node.left != null) record.add(node.left);
                if (node.right != null) record.add(node.right);
            }
            ans.add(0, result);
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        List<List<Integer>> lists = levelOrderBottom(root);
        System.out.println(lists);
    }
}
