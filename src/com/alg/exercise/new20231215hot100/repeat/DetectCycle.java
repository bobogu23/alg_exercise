package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * @Author: gu
 * @Date: 2023/12/23 下午6:06
 */
public class DetectCycle {

    //
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        boolean cycle = false;
        while (fast != null && fast.next != null){
            if(slow == fast){
                cycle = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if(!cycle){
            return null;
        }

        fast = head;
        while (fast != slow){
            fast =fast.next;
            slow =slow.next;
        }
        return slow;

    }


}
