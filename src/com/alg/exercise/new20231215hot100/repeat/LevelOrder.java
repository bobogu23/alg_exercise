package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/24 上午11:32
 */
public class LevelOrder {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0){
                TreeNode n = queue.poll();
                if(n.left != null){
                    queue.addLast(n.left);
                }
                if(n.right != null){
                    queue.addLast(n.right);
                }
                level.add(n.val);
                size--;
            }
            res.add(level);
        }

        return res;
    }

}
