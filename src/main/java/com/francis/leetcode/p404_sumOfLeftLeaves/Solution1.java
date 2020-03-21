package com.francis.leetcode.p404_sumOfLeftLeaves;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (isLeft && node.left == null && node.right == null) return node.val;
        int ans = 0;
        if (node.left != null) ans += sumOfLeftLeaves(node.left, true);
        if (node.right != null) ans += sumOfLeftLeaves(node.right, false);
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        System.out.println(sumOfLeftLeaves(root));
    }
}
