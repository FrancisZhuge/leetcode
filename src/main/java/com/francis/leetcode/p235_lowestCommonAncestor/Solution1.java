package com.francis.leetcode.p235_lowestCommonAncestor;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        Utils.printTree(root);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }
}
