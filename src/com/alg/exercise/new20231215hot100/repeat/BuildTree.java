package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

/**
 * @Author: gu
 * @Date: 2023/12/24 下午4:56
 */
public class BuildTree {

    //根据先序遍历的特点，找到root，然后 ，在中序遍历数组中找到root所在的位置
    //在中序数组中定位到root之后，就能知道左右子树的范围，
    //递归寻找root节点组装出整棵树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0, inorder.length-1);
    }

    private TreeNode build(int[] preorder,
                           int prestart,int preend,
                           int[] inorder,
                           int instart,int inend
                           ){

        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);
        int i = instart;// root 在inorder中的位置
        for(;i<=inend;i++){
            if(inorder[i] == rootval){
                break;
            }
        }

        int lefttreeSize = i - instart;

        //考虑边界情况
        if(lefttreeSize > 0){
            root.left = build(preorder,prestart+1,prestart+lefttreeSize,
                    inorder,instart,i-1);
        }

        int righttreeSize = inend - i;
        if(righttreeSize > 0){
            root.right = build(preorder,prestart+lefttreeSize+1,preend,
                    inorder, i+1,inend);
        }

       return root;
    }

}
