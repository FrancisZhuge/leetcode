package com.francis.leetcode.p145_postorderTraversal;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty())
            ans.add(stack2.pop().val);
        return ans;
    }


    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, null, 2, null, null, 3});
        Utils.printTree(root);
        System.out.println(postorderTraversal(root));

        root = Utils.createTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Utils.printTree(root);
        System.out.println(postorderTraversal(root));
    }
}
