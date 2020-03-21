package com.francis.leetcode.p404_sumOfLeftLeaves;

import com.francis.leetcode.utils.Utils;
import com.francis.leetcode.utils.entity.TreeNode;
import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhugequn
 * @since jdk8
 */
public class Solution2 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Boolean>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, false));

        int ans = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Boolean> node = queue.poll();
            Boolean isLeft = node.getValue();
            TreeNode cur = node.getKey();
            if (isLeft && cur.left == null && cur.right == null) ans += cur.val;
            if (cur.left != null) queue.add(new Pair<>(cur.left, true));
            if (cur.right != null) queue.add(new Pair<>(cur.right, false));
        }
        return ans;
    }

    @Test
    public void test() {
        TreeNode root = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        Utils.printTree(root);
        System.out.println(sumOfLeftLeaves(root));
    }
}
