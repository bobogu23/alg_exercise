package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/first-bad-version/?plan=leetcode_75&plan_progress=gb9pjkv
 *
 */
public class FirstBadVersion {

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        //二分查找
        //从中间开始找，找到错误的本，然后往二分查找前找正确版本，找到正确版本就往后二分找错误版本，
        //直到正确版本和错误版本的位置差为1，
        int low =1 ,high = n;
        int g = 0,b = 0;
        while (low <= high){
            int mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                b = mid;
                high = mid -1 ;
            }else {
                g = mid;
                low = mid + 1;
            }
            if(b - g == 1){
                return b;
            }
        }
        return 0;
    }

    public  boolean isBadVersion(int version){
        return true;
    };
}
