package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/16 下午11:00
 */
public class ThressSum_02 {

    public static void main(String[] args) {
        int[] a ={-1,0,1,2,-1,-4};
        ThressSum_02 t = new ThressSum_02();
        List<List<Integer>> l = t.threeSum(a);
        CollectionPrintUtils.printNestedIntArray(l);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //三数之和，k只需遍历到 倒数第三个数字。
        for(int k =0;k<len-2;k++){
            if(k > 0 && nums[k] == nums [k-1]){
                continue;
            }
            if(nums[k] > 0 ){
                break;
            }
            int i = k+1;
            int j = len-1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                //三数之和 < 0 ,i 移动，让nums[i] 变大
                if(sum < 0){
                    while ( i < j && nums[i] == nums[i+1]){
                        i++;
                    }
                    i++;
                }
                else if(sum > 0){
                    while ( i < j && nums[j] == nums[j-1]){
                        j--;
                    }
                    j--;
                }else  {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while ( i < j && nums[i] == nums[i+1]){
                        i++;
                    }
                    i++;
                    while ( i < j && nums[j] == nums[j-1]){
                        j--;
                    }
                    j--;
                }
            }

        }
        return res;


    }
}
