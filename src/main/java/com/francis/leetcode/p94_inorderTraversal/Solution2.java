package com.francis.leetcode.p94_inorderTraversal;

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
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> record = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !record.isEmpty()) {
            if (cur != null) {
                record.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = record.pop();
                ans.add(pop.val);
                cur = pop.right;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, null, 2, null, null, 3});
        Utils.printTree(root);
        System.out.println(inorderTraversal(root));

        root = Utils.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Utils.printTree(root);
        System.out.println(inorderTraversal(root));
    }
}
