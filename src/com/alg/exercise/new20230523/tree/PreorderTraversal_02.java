package com.alg.exercise.new20230523.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_02 {
    public static void main(String[] args) {
        PreorderTraversal_02 p = new PreorderTraversal_02();

        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r1l1 = new TreeNode(3);

        root.right = r1;
//        r1.left = r1l1;
        List<Integer> result = p.preorderTraversal(root);
        result.forEach(System.out::println);


    }

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }


    public static class TreeNode {
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
}
