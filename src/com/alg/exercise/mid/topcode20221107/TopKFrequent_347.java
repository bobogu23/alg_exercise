package com.alg.exercise.mid.topcode20221107;

import java.util.*;

public class TopKFrequent_347 {

    public static void main(String[] args) {
        TopKFrequent_347 f = new TopKFrequent_347();
        int[] a ={1,1,1,2,2,3};
        int[] res = f.topKFrequent(a, 2);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> numCount = new HashMap<>();
        for(int n : nums){
            numCount.put(n,numCount.getOrDefault(n,0)+1);
        }
        //按照出现频率排序
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
                Map.Entry.comparingByValue()
        );

        for(Map.Entry<Integer,Integer> e:numCount.entrySet()){
            queue.offer(e);
            //队列大小大于k，弹出出现频率最小的entry
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] res =new int[k];
        for(int i = k-1;i >= 0;i--){
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
