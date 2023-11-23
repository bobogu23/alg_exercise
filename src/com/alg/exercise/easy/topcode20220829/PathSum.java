package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/path-sum-iii/?plan=leetcode_75&plan_progress=zci8d5e
 * 给定一个二叉树的根节点 root  ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSum {


    //深度遍历每个节点，判断路径上节点总和等于targetSum的路径数量
    // 节点p,定义函数 rootSum(p,targetSum) 表示p节点起始，路径之和等于targetSum的路径数目
    //假设当前节点p的值等于v, 则rootSum(p,targetSum) = rootSum(p.left,targetSum-v)+rootSum(p.right,targetSum-v)
    //然后p的左子节点，右子节点 也是如此计算
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int sum = rootSum(root,targetSum);
        sum +=  pathSum(root.left,targetSum);
        sum +=  pathSum(root.right,targetSum);
        return sum;
    }

    public int rootSum(TreeNode n,int targetSum){
        if(n == null){
            return 0;
        }
        int res = 0;
        if(n.val == targetSum){
            ++res;
        }
        res +=rootSum(n.left,targetSum - n.val);
        res +=rootSum(n.right,targetSum - n.val);
        return res;
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
}
