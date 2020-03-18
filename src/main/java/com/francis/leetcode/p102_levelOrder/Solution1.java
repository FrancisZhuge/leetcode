package com.francis.leetcode.p102_levelOrder;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> record = new LinkedList<>();
        record.add(root);
        while (!record.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            int size = record.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = record.removeLast();
                result.add(node.val);
                if (node.left != null) record.addFirst(node.left);
                if (node.right != null) record.addFirst(node.right);
            }
            ans.add(result);
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
