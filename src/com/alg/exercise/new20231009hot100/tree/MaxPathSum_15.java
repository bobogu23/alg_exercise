package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边
 * 。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和
 * <p>
 * 定义一个函数计算 max ，节点n为根节点，从节点n为起始节点，到叶子节点的最大路径和 path。
 * <p>
 * 计算根节点为root的二叉树的最大路径和，只需要遍历整棵树，以每个节点为根节点root，计算它的左右子树的最大路径和：
 * path_l,path_r
 * 那么root的最大路径和为 path_l + path_r, 同时更新整棵树的最大路径和max
 *
 * @author ben.gu
 */
public class MaxPathSum_15 {
    public static void main(String[] args) {
        MaxPathSum_15 m = new MaxPathSum_15();
        TreeNode r = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        r.left = n2;
        r.right = n3;
        int sum = m.maxPathSum(r);
        System.err.println(sum);

        TreeNode nnegative_10 = new TreeNode(-10);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        nnegative_10.left=n9;
        nnegative_10.right=n20;
        n20.right=n7;
        n20.left=n15;
        m = new MaxPathSum_15();
        sum = m.maxPathSum(nnegative_10);
         System.err.println(sum);

        TreeNode r2 = new TreeNode(2);
        TreeNode nng1 = new TreeNode(-1);
        r2.left = nng1;

        m = new MaxPathSum_15();
        sum = m.maxPathSum(r2);
        System.err.println(sum);
        //[-1,5,null,4,null,null,2,-4]
        TreeNode rng1= new TreeNode(-1);
        TreeNode nn5= new TreeNode(5);
        TreeNode nn4= new TreeNode(4);
        TreeNode nn2= new TreeNode(2);
        TreeNode nnn4= new TreeNode(-4);
        rng1.left=nn5;
        rng1.left=nn5;


    }

    private int max = -1001;

    public int maxPathSum(TreeNode root) {

        //左右子节点为null，计算出的结果为 -1001
        int max_l = maxSumToLeaf(root.left);
        int max_r = maxSumToLeaf(root.right);
        if(max_l == -1001 && max_r == -1001){
            max = Math.max(max, root.val);
        }else {
            int max1 = max_l + max_r + root.val;
            int max2 = Math.max(max_l,max_r)+ root.val;
            //可能root不加子节点路径和 是最大的。
            //   //可能root+ （left||right） 是最大的。。
            //可能root + left + right 是最大的。
            max = Math.max(max, Math.max(root.val,Math.max(max1,max2)));
        }


        if (root.left != null) {
            maxPathSum(root.left);
        }
        if (root.right != null) {
            maxPathSum(root.right);
        }
        return max;
    }

    /**
     * 计算从root节点开始到叶子节点的所有路径中，和最大的
     *
     * @param root
     * @return
     */
    private int maxSumToLeaf(TreeNode root) {
        if (root == null) {
            return -1001;
        }
        int sum_l = maxSumToLeaf(root.left);
        int sum_r = maxSumToLeaf(root.right);
        if (sum_l == -1001 && sum_r == -1001) {
            return root.val;
        }
        return Math.max(root.val + Math.max(sum_l, sum_r),root.val);
    }

}
