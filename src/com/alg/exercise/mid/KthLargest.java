package com.alg.exercise.mid;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 使用快速排序
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.err.println(findKthLargest(arr, 4));
    }

    public static void quickSort1(int[] arr,int start,int end,int k){
        if(start>=end){
            return;
        }
        //快排后的元素下标
        int pivot = partition1(arr,start,end);
        if(pivot == k){
            return;
        }
        if(pivot < k){
            quickSort1(arr,pivot+1,end,k);
        }else {
            quickSort1(arr,start,pivot-1,k);
        }

    }

    private static int partition1(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for(int j = start;j<arr.length;j++){
            if(arr[j] < pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,end);
        return i;
    }


    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, nums.length - k);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int k) {
        quickSortA(nums, 0, nums.length - 1, k);
    }

    public static void quickSortA(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        if (pivot == k) {
            return;
        }
        // 从小到大排序,pivot < k ,说明第k大的元素在pivot右侧，
        // pivot位置上的元素对于整个数组从小到大排序后是正确的

        if (pivot < k) {
            quickSortA(nums, pivot + 1, end, k);
        } else {
            quickSortA(nums, start, pivot - 1, k);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        //最后一个元素做为pivot
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            //从小到大排序,小的放pivot的左边
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
