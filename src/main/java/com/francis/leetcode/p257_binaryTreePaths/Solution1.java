package com.francis.leetcode.p257_binaryTreePaths;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;

        binaryTreePaths(root, ans, "");
        return ans;
    }

    private void binaryTreePaths(TreeNode node, List<String> ans, String path) {
        path += node.val;
        if (node.left == null && node.right == null) ans.add(path);
        else {
            path += "->";
            if (node.left != null)
                binaryTreePaths(node.left, ans, path);
            if (node.right != null)
                binaryTreePaths(node.right, ans, path);
        }
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 3, null, 5});
        Utils.printTree(root);
        System.out.println(binaryTreePaths(root));
    }
}
