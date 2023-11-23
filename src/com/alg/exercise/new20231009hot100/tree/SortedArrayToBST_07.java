package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 二叉搜索树中序遍历就是一个升序链表
 *
 * @author ben.gu
 */
public class SortedArrayToBST_07 {
    public static void main(String[] args) {
        int[] nums ={-10,-3,0,5,9};
        SortedArrayToBST_07 s = new SortedArrayToBST_07();
        TreeNode treeNode = s.sortedArrayToBST(nums);
        System.err.println(treeNode);

    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode res = tree(nums,0,nums.length-1);
        return res;
    }

    private TreeNode tree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if(start == end){
            return new TreeNode(nums[start]);
        }
        int mid = (end + start) % 2 != 0 ? (end+start)/2 + 1 : (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = tree(nums, start, mid - 1);
        root.right = tree(nums, mid + 1, end);
        return root;
    }

}
