package com.francis.leetcode.p94_inorderTraversal;

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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode node, List<Integer> ans) {
        if (node != null) {
            inorder(node.left, ans);
            ans.add(node.val);
            inorder(node.right, ans);
        }
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
