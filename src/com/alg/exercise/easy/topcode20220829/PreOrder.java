package com.alg.exercise.easy.topcode20220829;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/?plan=leetcode_75&plan_progress=gb9pjkv
 *给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 */
public class PreOrder {

    public static void main(String[] args) {
        Node r= new Node(1);
//        Node r5= new Node(5);
//        Node r6= new Node(6);
//        Node r3= new Node(3);
//        r3.children = new ArrayList<>();
//        r3.children.add(r5);
//        r3.children.add(r6);
//
//        Node r2= new Node(2);
//        Node r4= new Node(4);
//
//        r.children = new ArrayList<>();
//        r.children.add(r3);
//        r.children.add(r2);
//        r.children.add(r4);
        Node r2= new Node(2);
        Node r3= new Node(3);
        Node r4= new Node(4);
        Node r5= new Node(5);
        Node r6= new Node(6);
        Node r7= new Node(7);
        Node r8= new Node(8);
        Node r9= new Node(9);
        Node r10= new Node(10);
        Node r11= new Node(11);
        Node r12= new Node(12);
        Node r13= new Node(13);
        Node r14= new Node(14);

        r11.children = new ArrayList<>();
        r11.children.add(r14);

        r7.children = new ArrayList<>();
        r7.children.add(r11);

        r3.children = new ArrayList<>();
        r3.children.add(r6);
        r3.children.add(r7);

        r8.children = new ArrayList<>();
        r8.children.add(r12);

        r4.children = new ArrayList<>();
        r4.children.add(r8);

        r9.children = new ArrayList<>();
        r9.children.add(r13);

        r5.children = new ArrayList<>();
        r5.children.add(r9);
        r5.children.add(r10);

        r.children = new ArrayList<>();
        r.children.add(r2);
        r.children.add(r3);
        r.children.add(r4);
        r.children.add(r5);


        List<Integer> nums = preorder(r);
        nums.forEach(e-> System.err.print(e+", "));


    }


    public static List<Integer> preorder(Node root) {
        //先遍历父节点，然后遍历左子节点，右子节点
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public static  void preorder(Node root,List<Integer> list) {
        //先遍历父节点，然后遍历左子节点，右子节点
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.children != null){
            for(Node n:root.children){
                preorder(n,list);
            }
        }

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


}
