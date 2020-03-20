package com.francis.leetcode.p222_countNodes;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == rightHeight)
            return (1 << leftHeight) + countNodes(root.right);
        return (1 << rightHeight) + countNodes(root.left);
    }

    private int height(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 3, 4, 5, 6});
        Utils.printTree(root);
        System.out.println(countNodes(root));
    }
}
