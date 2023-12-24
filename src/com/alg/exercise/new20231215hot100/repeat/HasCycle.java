package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午6:01
 */
public class HasCycle {


    //快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next ==null){
          return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
