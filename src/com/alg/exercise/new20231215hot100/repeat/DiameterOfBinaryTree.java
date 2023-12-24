package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

/**
 * @Author: gu
 * @Date: 2023/12/24 上午10:56
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;

        DiameterOfBinaryTree t = new DiameterOfBinaryTree();
        int res = t.diameterOfBinaryTree(t1);
        System.err.println(res);

    }


    //递归求每个节点的左右子树的边数，最长路径 = max(左右子树边数之和，左右子树边数最大值)
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return res;
        }

        int lmaxpath = path(root.left);
        int rmaxpath = path(root.right);
        int max = max(lmaxpath, rmaxpath, lmaxpath + rmaxpath);
        res = Math.max(res,max);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return res;
    }

    private int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));

    }

    private int path(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(path(root.left),path(root.right))+1;
    }


}
