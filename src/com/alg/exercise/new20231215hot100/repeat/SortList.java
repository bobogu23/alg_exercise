package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午10:18
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a->a.val));
        //遍历链表 放入小顶堆，并且将链表next指针断开
        ListNode p = head;
        ListNode pre = null;
        while (p != null){
            queue.offer(p);
            if(pre != null){
                pre.next =null;
            }
            pre = p;
            p = p.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur =cur.next;
        }
        return dummy.next;

    }
}
