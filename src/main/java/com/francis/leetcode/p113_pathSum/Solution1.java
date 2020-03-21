package com.francis.leetcode.p113_pathSum;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        pathSum(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    private void pathSum(TreeNode node, int sum, List<Integer> record, List<List<Integer>> ans) {
        sum -= node.val;
        record.add(node.val);
        if (node.left == null && node.right == null && sum == 0)
            ans.add(record);
        else {
            if (node.left != null) pathSum(node.left, sum, new ArrayList<>(record), ans);
            if (node.right != null) pathSum(node.right, sum, new ArrayList<>(record), ans);
        }
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        Utils.printTree(root);
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(lists);
    }
}
