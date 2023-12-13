package com.alg.exercise.new20231009hot100.dp;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 杨辉三角：
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和
 * <p>
 * 动态规划：
 * dp 函数  list<int> dp (n) 第 n 产生的数组
 * <p>
 * base case
 * dp(1) -> [1]
 * <p>
 * 状态: n.
 * 选择： 基于n-1行，第n行的数组大小为n,数组第一个数字固定为 1 ,数组最后一个数字固定为1.
 * 数组其他位置的数字 等于 n-1行的数组 中 j-1，j 位置的数字之和
 *
 * @Author: gu
 * @Date: 2023/12/13 上午11:24
 */
public class YanghuiTriangle_11 {
    public static void main(String[] args) {
        YanghuiTriangle_11 yh = new YanghuiTriangle_11();
        List<List<Integer>> res = yh.generate(5);
        CollectionPrintUtils.printNestedIntArray(res);
    }


    public List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>(numRows);
        dp(numRows);

        return res;
    }

    private List<List<Integer>> res;

    public List<Integer> dp(int numRows) {
        //base case
        if (numRows == 1) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            res.add(arr);
            return arr;
        }

        List<Integer> pre = dp(numRows - 1);
        List<Integer> cur = new ArrayList<>(numRows);
        for (int i = 0; i < numRows ; i++) {
            //第一列，最后一列固定为1
            if(i == 0 || i == numRows -1){
                cur.add(1);
            }else {
                //基于n-1列计算
                int val = pre.get(i-1) + pre.get(i);
                cur.add(val);
            }

        }
        //加入结果集
        res.add(cur);
        return cur;
    }

}
