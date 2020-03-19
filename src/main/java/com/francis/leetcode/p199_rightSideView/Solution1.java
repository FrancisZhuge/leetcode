package com.francis.leetcode.p199_rightSideView;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution1 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        while (!record.isEmpty()) {
            int size = record.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = record.poll();
                if (node.left != null) record.add(node.left);
                if (node.right != null) record.add(node.right);
                if (i == size - 1) ans.add(node.val);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        Utils.printTree(root);
        System.out.println(rightSideView(root));
    }

}
