package com.francis.leetcode.p102_levelOrder;

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
public class Solution3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> record = new LinkedList<>();
        record.add(root);
        int levelNum = 1;
        while (!record.isEmpty()) {
            int tempLevelNum = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = record.poll();
                result.add(node.val);
                if (node.left != null) {
                    record.add(node.left);
                    tempLevelNum++;
                }
                if (node.right != null) {
                    record.add(node.right);
                    tempLevelNum++;
                }

            }
            ans.add(result);
            levelNum = tempLevelNum;
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }
}
