package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/?favorite=2cktkvj
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 */
public class FindDuplicate_287 {
    public static void main(String[] args) {
        FindDuplicate_287 f = new FindDuplicate_287();
        int[]  a = {3,1,3,4,2};
        System.err.println(f.findDuplicate(a));
        System.err.println(f.findDuplicate1(a));

    }


    /*
     *
     */
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 1 ){
            return 0;
        }
        for(int i =0 ;i < nums.length;i++){
            int num = nums[i];
            for(int j = 0 ;j < nums.length;j++){
               if(j != i && nums[j] == num){
                   return nums[j];
               }
            }
        }
        return 0;

    }

    /**
     * 类似于判断链表中是否存在环
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int fast = 0;
        int slow = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int head = 0;
        while (head != slow){
            slow = nums[slow];
            head = nums[head];
        }
        return head;
    }

}
