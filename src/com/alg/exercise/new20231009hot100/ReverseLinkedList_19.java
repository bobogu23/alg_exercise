package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author ben.gu
 */
public class ReverseLinkedList_19 {

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
