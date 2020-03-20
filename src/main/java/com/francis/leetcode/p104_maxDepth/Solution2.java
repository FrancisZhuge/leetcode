package com.francis.leetcode.p104_maxDepth;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return len;
    }

    @Test
    public void test() {
        System.out.println(maxDepth(Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
