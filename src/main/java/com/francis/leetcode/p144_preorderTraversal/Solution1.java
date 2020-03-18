package com.francis.leetcode.p144_preorderTraversal;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> record = new Stack<>();
        record.add(root);
        while (!record.isEmpty()) {
            TreeNode node = record.pop();
            ans.add(node.val);
            if (node.right != null) record.push(node.right);
            if (node.left != null) record.push(node.left);
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, null, 2, null, null, 3});
        Utils.printTree(root);
        System.out.println(preorderTraversal(root));

        root = Utils.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Utils.printTree(root);
        System.out.println(preorderTraversal(root));
    }
}
