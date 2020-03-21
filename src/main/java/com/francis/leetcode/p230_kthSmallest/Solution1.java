package com.francis.leetcode.p230_kthSmallest;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if (count == k - 1) return root.val;
        if (count < k - 1) return kthSmallest(root.right, k - count - 1);
        else return kthSmallest(root.left, k);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return count(node.left) + count(node.right) + 1;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 1, 4, null, 2});
        Utils.printTree(root);
        System.out.println(kthSmallest(root, 1));

        root = Utils.createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        Utils.printTree(root);
        System.out.println(kthSmallest(root, 4));
    }
}
