package com.alg.exercise.easy.topcode20220829;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * 最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/?plan=leetcode_75&plan_progress=gb9pjkv
 *
 *
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode r= new TreeNode(6);
        TreeNode n2= new TreeNode(2);
        TreeNode n8= new TreeNode(8);
        TreeNode n0= new TreeNode(0);
        TreeNode n4= new TreeNode(4);

        r.left = n2;
        r.right = n8;

        n2.left = n0;
        n2.right = n4;

        TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(r, n2, n4);
        System.err.println(treeNode.val);
    }


    /**
     * 两次遍历，寻找p，和q，同时把寻找p，q过程中经历的节点存起来，也就是遍历的路径。
     * 遍历寻找p,q路径上的节点，找到最后一个相同的节点，就是最近的公共节点
     *              9
     *           /    \
     *          4       10
     *        /  \
     *       1    5
     * 求 1，5, 的公共节点，（公共节点4）
     * 遍历到1的路径 9,4,1
     * 遍历到5的路径 9,4,5
     *
     * 两条路径的节点中，值相同的最后一个公共节点是 4
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> tracep = new ArrayList<>();
        findNode(root,p,tracep);
        List<TreeNode> traceq = new ArrayList<>();;
        findNode(root,q,traceq);
        int i = 0;
        for( ; i< Math.min(tracep.size(),traceq.size()) ; i++){
            if(tracep.get(i).val != traceq.get(i).val){
                return tracep.get(i-1);
            }
        }
        return tracep.get(i-1);
    }

    private void findNode(TreeNode root, TreeNode q,List<TreeNode> list) {
          list.add(root);
          if(root.val == q.val){
              return;
          }
          if(root.val > q.val){
              findNode(root.left,q,list);
          }else {
              findNode(root.right,q,list);
          }
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

        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
