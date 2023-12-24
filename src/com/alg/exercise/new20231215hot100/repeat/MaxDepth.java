package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

/**
 * @Author: gu
 * @Date: 2023/12/24 上午10:16
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int mleft = maxDepth(root.left);
        int mright = maxDepth(root.right);
        return Math.max(mleft,mright) + 1;

    }


}
