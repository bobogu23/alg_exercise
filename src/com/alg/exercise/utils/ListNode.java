package com.alg.exercise.utils;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午4:42
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void print(){
        System.err.print(val);
        if(next != null){
            System.err.print(",");
            next.print();
        }
    }
}
