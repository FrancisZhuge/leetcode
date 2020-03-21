package com.francis.leetcode.p108_sortedArrayToBST;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);
        int mid = (r - l) / 2 + l;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = sortedArrayToBST(nums, l, mid - 1);
        midNode.right = sortedArrayToBST(nums, mid + 1, r);
        return midNode;
    }

    @Test
    public void test() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        Utils.printTree(root);
    }
}
