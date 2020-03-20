package com.francis.leetcode.p222_countNodes;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 3, 4, 5, 6});
        Utils.printTree(root);
        System.out.println(countNodes(root));
    }
}
