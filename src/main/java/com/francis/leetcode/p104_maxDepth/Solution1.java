package com.francis.leetcode.p104_maxDepth;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @Test
    public void test() {
        System.out.println(maxDepth(Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
