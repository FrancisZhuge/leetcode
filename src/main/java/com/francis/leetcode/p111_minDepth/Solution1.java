package com.francis.leetcode.p111_minDepth;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }

    @Test
    public void test() {
        System.out.println(minDepth(Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

}
