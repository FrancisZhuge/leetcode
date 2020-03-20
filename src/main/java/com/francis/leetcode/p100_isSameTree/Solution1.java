package com.francis.leetcode.p100_isSameTree;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void test() {
        TreeNode root_1 = Utils.createTree(new Integer[]{1, 2, 3});
        TreeNode root_2 = Utils.createTree(new Integer[]{1, 2, 3});
        System.out.println(isSameTree(root_1, root_2));

        root_1 = Utils.createTree(new Integer[]{1, 2});
        root_2 = Utils.createTree(new Integer[]{1, null, 2});
        System.out.println(isSameTree(root_1, root_2));

        root_1 = Utils.createTree(new Integer[]{1, 2, 1});
        root_2 = Utils.createTree(new Integer[]{1, 1, 2});
        System.out.println(isSameTree(root_1, root_2));
    }
}
