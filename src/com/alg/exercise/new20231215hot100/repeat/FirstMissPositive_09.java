package com.alg.exercise.new20231215hot100.repeat;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午12:16
 */
public class FirstMissPositive_09 {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int miss = 1;
        for(int n : nums){
            set.add(n);
            while (!set.isEmpty() && set.contains(miss)){
                miss++;
            }
        }
        return miss;

    }


}
