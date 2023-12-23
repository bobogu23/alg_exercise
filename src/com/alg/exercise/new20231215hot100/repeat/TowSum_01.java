package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: gu
 * @Date: 2023/12/15 下午10:37
 */
public class TowSum_01 {
    public static void main(String[] args) {
        int[] a = {3,2,4};
        TowSum_01 t = new TowSum_01();
        int[] sum = t.twoSum(a, 6);
        CollectionPrintUtils.printArray(sum);
    }


    public int[] twoSum(int[] nums, int target) {
        //map记录每个数字的位置。
        //遍历数组，每个数字n，从map中寻找target-n 是否存在
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> l = map.get(n);
            if(l == null){
                l = new ArrayList<>();
            }
            l.add(i);
            map.put(n,l);
        }

        for(int i = 0;i<nums.length;i++){
            List<Integer> l = null;
            if(( l = map.get(target-nums[i]) )!= null){
                if(target-nums[i] == nums[i]
                        && l.size()>1 ){
                    return new int[]{i,l.get(1)};
                }else if(target-nums[i] != nums[i]){
                    return new int[]{i,l.get(0)};
                }
            }
        }



        return new int[]{};

    }




}
