package com.alg.exercise.mid;

import java.util.*;

//从左往右，逐层遍历二叉树
public class BinaryTreeLevelOrder2 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //将左右子节点放在队列中，然后取当前节点的值
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode>  queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //判断当前队列大小，取队列大小个数的节点，每个节点有左右子节点，放入队列末尾
            int size = queue.size();
            for(int i =0 ;i < size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }
}
