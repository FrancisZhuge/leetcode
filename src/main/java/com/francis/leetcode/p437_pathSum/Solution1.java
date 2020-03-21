package com.francis.leetcode.p437_pathSum;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int path(TreeNode node, int sum) {
        if (node == null) return 0;
        int ans = 0;
        if (node.val == sum) ans++;
        ans += path(node.left, sum - node.val);
        ans += path(node.right, sum - node.val);
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        Utils.printTree(root);
        System.out.println(pathSum(root, 8));
    }
}
