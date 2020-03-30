package com.francis.leetcode.algorithms_for_java.ch_5_binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhugequn
 * @since jdk8
 */
public class BST<E extends Comparable<E>> {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 大小
     */
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 树大小
     *
     * @return 大小
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node 节点
     * @param e    值
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     *
     * @param e 查询值
     * @return 是否存在
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e, 递归算法
     *
     * @param node 节点
     * @param e    查询值
     * @return 是否包含
     */
    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) return true;
        else if (e.compareTo(node.e) < 0) return contains(node.left, e);
        else return contains(node.right, e);
    }


    public void preOrder() {
        List<E> result = new ArrayList<>();
        preOrder_recursive(root, result);
        System.out.println(result);
    }

    private void preOrder_recursive(Node node, List<E> ans) {
        if (node != null) {
            ans.add(node.e);
            preOrder_recursive(node.left, ans);
            preOrder_recursive(node.right, ans);
        }
    }

    private void preOrder(Node node, List<E> ans) {
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            ans.add(pop.e);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder() {
        List<E> result = new ArrayList<>();
        inOrder_recursive(root, result);
        System.out.println(result);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node node
     * @param ans  结果集
     */
    private void inOrder_recursive(Node node, List<E> ans) {
        if (node == null)
            return;

        inOrder_recursive(node.left, ans);
        ans.add(node.e);
        inOrder_recursive(node.right, ans);
    }

    private void inOrder(Node node, List<E> ans) {
        if (node == null) return;
        Stack<Node> record = new Stack<>();
        Node cur = node;
        while (cur != null || !record.isEmpty()) {
            if (cur != null) {
                record.push(cur);
                cur = cur.left;
            } else {
                Node pop = record.pop();
                ans.add(pop.e);
                cur = pop.right;
            }
        }
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        List<E> result = new ArrayList<>();
        postOrder_recursive(root, result);

    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     *
     * @param node 节点
     */
    private void postOrder_recursive(Node node, List<E> ans) {
        if (node == null)
            return;

        postOrder_recursive(node.left, ans);
        postOrder_recursive(node.right, ans);
        ans.add(node.e);
    }

    private void postOrder(Node node, List<E> ans) {
        if (node == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);
        while (!stack1.isEmpty()) {
            Node pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) stack1.push(pop.left);
            if (pop.right != null) stack1.push(pop.right);
        }
        while (!stack2.isEmpty()) {
            ans.add(stack2.pop().e);
        }
    }

    /**
     * 二分搜索树的层序遍历
     */
    public void levelOrder() {
        if (root == null)
            return;

        Queue<Node> record = new LinkedList<>();
        record.add(root);
        while (!record.isEmpty()) {
            Node cur = record.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                record.add(cur.left);
            if (cur.right != null)
                record.add(cur.right);
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return 最小值
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node 查找节点
     * @return 最小值
     */
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return 最大值
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node 节点
     * @return 最大值
     */
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return 删除值
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node 节点
     * @return 节点
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return 删除值
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node 节点
     * @return 节点
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e 值
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node 节点
     * @param e    值
     * @return 节点
     */
    private Node remove(Node node, E e) {
        if (node == null) return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}


































