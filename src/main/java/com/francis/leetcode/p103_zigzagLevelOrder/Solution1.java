package com.francis.leetcode.p103_zigzagLevelOrder;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        boolean odd = true;
        while (!record.isEmpty()) {
            int size = record.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = record.poll();
                if (odd) result.add(node.val);
                else result.add(0, node.val);
                if (node.left != null) record.add(node.left);
                if (node.right != null) record.add(node.right);
            }
            odd = !odd;
            ans.add(result);
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
