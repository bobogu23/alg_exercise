package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.CollectionPrintUtils;
import com.alg.exercise.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: gu
 * @Date: 2023/12/24 上午9:53
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        root.left=n2;
        root.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;

        InorderTraversal t = new InorderTraversal();
        List<Integer> res = t.inorderTraversal(root);
        CollectionPrintUtils.printList(res);

    }



    private List<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        //使用栈
        TreeNode t = root;
        Stack<TreeNode> stack = new Stack<>();
        while(t != null){
            stack.push(t);
            t = t.left;
        }

        //出栈的时候判断是否存在右节点，进栈的时候判断是否存在左节点
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            res.add(n.val);
            //n出栈，插入右子树的左节点
            if(n.right != null){
                pushStack(stack,n.right);
            }
        }
        return res;
    }

    private void pushStack(Stack<TreeNode> stack,TreeNode n){
        while(n != null){
            stack.push(n);
            n = n.left;
        }
    }



}
