package com.alg.exercise.new20231009hot100.greed;

/**
 * https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * <p>
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * <p>
 * 解法：
 * 贪心算法：
 * 每次选择局部最优，最终达到全局最优。
 * <p>
 * 每次在 可达到的范围内选择 下一跳可以跳更远的位置。
 * <p>
 * 【2，3，1，1，4，2，1】
 * 从位置0开始，最大可以跳2格，就是可以达到 3 或者 1，
 * 这里选择 3 的位置，因为它最大可以跳3格。
 * <p>
 * 达到3之后，它最大可以跳3格，也就是能到达 1,1,4位置，
 * 这里选择跳到 4 位置，因为它最大可以跳4格。
 *
 * @Author: gu
 * @Date: 2023/12/10 下午10:21
 */
public class Jump_03 {

    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int end = 0;//更新边界
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) { // 更新边界 为了更新跳跃的次数
                end = farthest;
                steps++;
            }

        }
        return steps;
    }

}
