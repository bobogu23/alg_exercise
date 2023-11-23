package com.alg.exercise.mid;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * <p>
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）
 * 。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 有序数组 使用二分查找法
 */
public class SearchRotateArray {
    public static void main(String[] args) {
        SearchRotateArray searchRotateArray = new SearchRotateArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums1 = {1};
        System.err.println(searchRotateArray.search(nums, 0));
        ;
        System.err.println(searchRotateArray.search(nums, 3));
        ;
        System.err.println(searchRotateArray.search(nums1, 0));

        System.err.println(searchRotateArray.search1(nums, 0));
        System.err.println(searchRotateArray.search1(nums, 3));
        System.err.println(searchRotateArray.search1(nums1, 0));


    }


    //方法1：直接遍历数组
    //方法2：遍历数组，找到发生旋转的下标，前一个元素比当前元素大，说明当前元素之后的元素升序排列
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            //下标i之后的数据升序，当前下标对应的元素> target,后面就不用再遍历了
            if (i - 1 >= 0 && nums[i - 1] > nums[i] && nums[i] > target) {
                return -1;
            }
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //右边数组有序
            if (nums[mid] < nums[right]) {
                //target 在 mid 和right之间,移动left
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    // target 不在mid 和right之间，往左边寻找
                    right = mid - 1;
                }
            } else {//左边数组有序
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    // target 不在mid 和left之间，往右边寻找
                    left = mid + 1;
                }
            }
        }
        return -1;
//
//        for(int i = 0 ;i<nums.length;i++){
//            if(nums[i] == target){
//                return i;
//            }
//            //下标i之后的数据升序，当前下标对应的元素> target,后面就不用再遍历了
//            if(i-1>=0 && nums[i-1] > nums[i] && nums[i]>target){
//                return -1;
//            }
//        }
//        return -1;
    }
}
