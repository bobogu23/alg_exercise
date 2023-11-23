package com.alg.exercise.new20230803.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * 用遍历，还是递归。每个节点需要做什么操作
     * 遍历有问题，r1的右节点无法连接 r2的左节点
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        tranverse(root.left, root.right);
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node l = queue.poll();
                if (i < size - 1) {
                    Node r = queue.peek();
                    l.next = r;
                }
                if (l.left != null) {
                    queue.add(l.left);
                }
                if (l.right != null) {
                    queue.add(l.right);
                }
            }
        }
        return root;
    }


    void tranverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        //节点连起来
        node1.next = node2;
        //连接子节点
        tranverse(node1.left, node1.right);
        tranverse(node2.left, node2.right);
        //跨父节点的两个子节点相连
        tranverse(node1.right, node2.left);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
