package com.alg.exercise.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * 用两个指针，从每个数组的后面开始遍历，取较大的放在最后面。
 *
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int m =3;
         int[] nums2 = {2,5,6} ;
         int n = 3;
        merge(nums1,m,nums2,n);
        printArray(nums1);
    }
    private static void printArray(int[] nums){
        Arrays.stream(nums).forEach(System.err::print);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
          int tail = nums1.length - 1;
          int index1 = m-1;
          int index2 = n-1;
          int cur = 0;
          while (index1 >= 0 || index2 >= 0){
              if(index1 == -1 ){
                  cur = nums2[index2--];
              }else if(index2 == -1){
                  cur = nums1[index1--];
              }else if(nums2[index2] >nums1[index1] ){
                  cur = nums2[index2--];
              }else {
                  cur = nums1[index1--];
              }
              nums1[tail--] = cur;
          }
    }
}
