package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * @author ben.gu
 */
public class LinkedListCycle_21 {

    public static void main(String[] args) {


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //reverse 返回反转后链表的头节点
        ListNode last  = reverse(head.next);
//        1 -> reverse(head.next) , 1 -> 2 <- 3 <- 4 <- 5 <- 6
        head.next.next = head; // 1.next =2,  2 的next改成 1
        head.next = null; // 1.next 改成null
        return last;
    }

}
