package com.francis.leetcode.p98_isValidBST;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> record = new ArrayList<>();
        inorder(root, record);
        for (int i = 0; i < record.size() - 1; i++)
            if (record.get(i) >= record.get(i + 1)) return false;
        return true;
    }

    private void inorder(TreeNode node, List<Integer> order) {
        if (node == null) return;
        inorder(node.left, order);
        order.add(node.val);
        inorder(node.right, order);
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        Utils.printTree(root);
        System.out.println(isValidBST(root));

        root = Utils.createTree(new Integer[]{2, 1, 3});
        Utils.printTree(root);
        System.out.println(isValidBST(root));
    }
}
