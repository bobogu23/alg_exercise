package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked
 *
 *
 * @Author: gu
 * @Date: 2023/12/24 下午10:13
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-3);

        root.left =n2;
        root.right =n3;

//        TreeNode n4 =new TreeNode(4);
//        TreeNode n8 =new TreeNode(8);
//        root.left =n4;
//        root.right =n8;
//
//        TreeNode n11 =new TreeNode(11);
//        n4.left =n11;
//
//
//        TreeNode n7 =new TreeNode(7);
//        TreeNode n2 =new TreeNode(2);
//        n11.left=n7;
//        n11.right=n2;
//
//        TreeNode n13 =new TreeNode(13);
//        TreeNode n44 =new TreeNode(4);
//
//        n8.left=n13;
//        n8.right=n44;
//
//        TreeNode n5 =new TreeNode(5);
//        TreeNode n1 =new TreeNode(1);
//
//        n44.left=n5;
//        n44.right=n1;

        PathSum p = new PathSum();
        int r = p.pathSum(root,-1);
        System.err.println(r);

    }




    //统计前缀和次数，key：前缀和，value：次数
    private Map<Long,Integer> presum = new HashMap<>();
    private int target = 0;
    //前缀和思想
    public int pathSum(TreeNode root, int targetSum) {
       presum.put(0L,1);
        target = targetSum;
              return sum(root,0L);
    }

    //cursum 到父节点为止的前缀和
    private int sum(TreeNode root, long cursum){
        if(root == null){
           return 0;
        }
        //到当前节点的前缀和
        cursum += root.val;

        //是否存在前缀和= cursum-target
        int count = presum.getOrDefault(cursum-target,0);
        presum.put( cursum,presum.getOrDefault(cursum,0)+1);
        //递归子节点
        int left = sum(root.left,cursum);
        int right = sum(root.right,cursum);
        int res = count+left+right;
        //子节点前缀和遍历完了，把当前节点的前缀和去掉，用不到了，而且不能影响其他节点的前缀和计算
        presum.put(cursum,presum.get(cursum)-1);
        return res;
    }
}
