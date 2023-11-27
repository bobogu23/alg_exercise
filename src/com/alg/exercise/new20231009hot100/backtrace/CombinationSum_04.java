package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 *
 * @author ben.gu
 */
public class CombinationSum_04 {
    public static void main(String[] args) {
        int target = 7;
        int[] candidates ={2,3,6,7};
        CombinationSum_04 cs = new CombinationSum_04();
        List<List<Integer>> res = cs.combinationSum(candidates, target);
        CollectionPrintUtils.printNestedIntArray(res);
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrace(candidates,target,0);
        return res;
    }


    //candidates 中的元素可以被重复使用，回溯的时候，start 不需要+1
    private void backtrace(int[] candidates, int target,int start) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int n = candidates[i];
            tmp.add(n);
            backtrace(candidates,target-n,i);
            tmp.removeLast();
        }
    }

}
