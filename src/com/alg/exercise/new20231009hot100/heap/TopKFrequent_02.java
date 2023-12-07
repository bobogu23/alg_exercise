package com.alg.exercise.new20231009hot100.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 用hash表 统计出每个数字出现的次数，
 * 统计出现次数前k大的次数值。
 * <p>
 * 解法2：桶排序
 * 用hash表 统计出每个数字出现的次数，
 * 建一个数组，下标对应每个数字出现次数，下标位置上存放对应的数字列表。
 * 取前k高的元素，只需倒序遍历数组，遍历k个即可。
 *
 * @author ben.gu
 */
public class TopKFrequent_02 {


    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //数字至少出现一次，下标0的位置上不会放数字，
        List<Integer>[] list = new ArrayList[nums.length + 1];
        //key 是数字
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (list[count] == null) {
                list[count] = new ArrayList<>();
            }
            list[count].add(key);
        }
        int[] res = new int[k];
        int c = 0;//计数
        for (int i = list.length - 1; i >= 1; i--) {
            List<Integer> num = list[i];
            if (num == null) {
                continue;
            }
            //从出现次数最大的位置开始取数，取k个
            for (Integer n : num) {
                res[c] = n;
                c++;
                if (c == k) {
                    return res;
                }
            }
        }
        return res;
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            //按照 频率排序
            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.offer(e);
            //剔除最小的数据
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //取出堆中的数据
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }


}
