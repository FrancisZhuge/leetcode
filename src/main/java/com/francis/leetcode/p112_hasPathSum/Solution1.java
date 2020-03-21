package com.francis.leetcode.p112_hasPathSum;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1});
        Utils.printTree(root);
        System.out.println(hasPathSum(root, 22));
    }
}
