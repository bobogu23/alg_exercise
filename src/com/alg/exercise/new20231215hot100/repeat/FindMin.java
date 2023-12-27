package com.alg.exercise.new20231215hot100.repeat;

/**
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组
 * 。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @Author: gu
 * @Date: 2023/12/26 上午11:47
 */
public class FindMin {

    public static void main(String[] args) {
        int[] a ={11,13,15,17};
        FindMin f = new FindMin();
        int min = f.findMin(a);
        System.err.println(min);
    }

    //数组不断分割，在有序区间内取最左边的数字
    public int findMin(int[] nums) {
        int res =  5001;
        if(nums.length == 1){
            return nums[0];
        }

        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = high -(high-low)/2;
            int n = nums[mid];
            // low ~ mid 区间有序, 可能不是整个数组的最小值
            if(nums[low] <= n){
                res = Math.min(res,nums[low]);
                low = mid +1;
            }else if(n <= nums[high]){
                // mid ~ high 区间有序，可能不是整个数组的最小值
                res = Math.min(n,res);
                high = mid-1;
            }
        }

        return res;
    }

}
