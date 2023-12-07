package com.alg.exercise.new20231009hot100.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 方法1：
 * 使用最小堆，遍历数组，将数组中每个元素遍历一遍放入堆中。
 * 堆顶部是最小的元素，当堆大小超过k时，删除堆顶的元素。整个数组遍历完之后，堆顶元素就是第k个最大元素
 * <p>
 * 方法2：
 * 快排。
 * 快排中partition 方法将数字p 放在了正确的位置i上，如果i= n-k 说明p就是第k大的元素。
 * <p>
 * M每次使用partition 方法选择出一个位置i时，判断 如果 i < n-k,则在 i+1 ~ h, 区间执行partition,
 * 如果 i > n-k ,则 在 lo , i-1 区间执行partition,
 * 否则return nums[i]
 *
 * @author ben.gu
 */
public class FindKthLargest_01 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = partition(nums, lo, hi);
            if (p < k) { // p在k的左边
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                return nums[p];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        //切分 lo+1 ~ hi,将小于 pivot的放在数组左边，大于pivot的放在数组右边
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
                //退出while循环时，lo ~ i-1 <= pivot
                // [lo ~ i) <= pivot
            }

            while (j > lo && nums[j] > pivot) {
                j--;
                //退出while循环时，j+1,hi > pivot
                // (j,hi] > pivot
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        //将pivot 放到正确位置。此时j所在位置的元素 < pivot，可以直接放到lo的位置。
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }


}
