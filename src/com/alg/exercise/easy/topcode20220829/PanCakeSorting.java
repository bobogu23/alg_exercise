package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pancake-sorting/
 * 煎饼翻转
 *
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 * 思路
 * 数组长度n
 * 1.遍历前n个数字，从数组中找出最大的数字，进行煎饼翻转，让最大的数字排在第一个，然后选择k=n,进行煎饼翻转，使得最大的数字排在最后。
 * 2.遍历前n-1个数字，从子数组中找出最大的数字，进行煎饼翻转，让最大的数字排在第一个，然后选择k=n,进行煎饼翻转，使得最大的数字排在最后。

 */
public class PanCakeSorting {
    public static void main(String[] args) {
        PanCakeSorting sorting = new PanCakeSorting();
        int[] arr = {1,2,3};
        List<Integer> res = sorting.pancakeSort(arr);
        res.forEach(System.out::println);
    }

    public  List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        sort(arr,n,res);
        return res;
    }

    public void sort(int[] arr,int len,List<Integer> res ){
        if(len == 1){
            return;
        }
        //找到数组中最大的数字的索引
        int maxIndex =  0;
        int max =  0;
        for(int i = 0;i<len;i++){
            if(arr[i] > max ){
                max = arr[i];
                maxIndex = i;
            }
        }
        //最大的数字翻转到第一个位置
        reverse(arr,0,maxIndex);
        res.add(maxIndex+1);
        //然后整个数组翻转，使得最大的数字翻转到最后一个位置
        reverse(arr,0,len-1);
        res.add(len);
        //排序前len-1长度的子数组
        sort(arr,len-1,res);
    }

    public void reverse(int[] arr,int start,int end){
        while (start < end){
            int tem=  arr[start];
            arr[start] = arr[end];
            arr[end] = tem;
            start++;
            end--;
        }

    }


}
