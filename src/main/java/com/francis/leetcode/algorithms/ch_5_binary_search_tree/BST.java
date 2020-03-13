package com.francis.leetcode.algorithms.ch_5_binary_search_tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hzzhugequn@corp.netease.com
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);

    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.key + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    public Key minimum() {
        assert count != 0;
        return minimum(root).key;
    }

    public Key maximum() {
        assert count != 0;
        return maximun(root).key;
    }

    public void removeMin() {
        if (root != null)
            root = removeMin(root);
    }

    public void removeMax() {
        if (root != null)
            root = removeMax(root);
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    // *******
    // 辅助函数
    // *******
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0)
            node.value = value;
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key, value);
        else
            node.left = insert(node.left, key, value);
        return node;
    }

    private boolean contain(Node node, Key key) {
        if (node == null)
            return false;
        if (key.compareTo(node.key) == 0)
            return true;
        else if (key.compareTo(node.key) > 0)
            return contain(node.right, key);
        else
            return contain(node.left, key);
    }

    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0)
            return node.value;
        else if (key.compareTo(node.key) > 0)
            return search(node.right, key);
        else
            return search(node.left, key);
    }

    // 对以node为根的二叉搜索树进行前序遍历, 递归算法
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历, 递归算法
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历, 递归算法
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) return node;
        return minimum(node);
    }

    private Node maximun(Node node) {
        if (node.right == null) return node;
        return maximun(node.right);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node remove(Node node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }
        Node successor = new Node(minimum(node.right));
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = node.right = null;
        return successor;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
        }
    }

    @Test
    public void test() {
        int n = 10;
        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        // 打乱数组顺序
        for (int i = 0; i < n; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        BST<Integer, String> bst = new BST<>();
        for (int i = 0; i < n; i++)
            bst.insert(arr[i], arr[i] + "");
//        // 对[0...2*N)的所有整型测试在二分搜索树中查找
//        // 若i在[0...N)之间，则能查找到整型所对应的字符串
//        // 若i在[N...2*N)之间，则结果为null
//        for (int i = 0; i < 2 * n; i++) {
//            String res = bst.search(i);
//            if (i < n) {
//                assert res.equals(i + "");
//            } else
//                assert res == null;
//        }

//        bst.preOrder();
//        bst.inOrder();
//        bst.postOrder();
        bst.levelOrder();

    }
}
