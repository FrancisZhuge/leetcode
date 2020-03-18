package com.francis.leetcode.p144_preorderTraversal;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode node, List<Integer> ans) {
        if (node != null) {
            ans.add(node.val);
            preorder(node.left, ans);
            preorder(node.right, ans);
        }
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
