package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * @author ben.gu
 */
public class AddTwoNumbers_24 {


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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;
        int temp = 0;//进位
        ListNode p1 = l1;
        ListNode p2 = l2;
        //两个链表没有遍历完 或者还有进位 需要继续遍历执行
        while (p1 != null || p2 != null || temp > 0) {
            int val = temp;
            if (p1 != null) {
                val = val + p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val = val + p2.val;
                p2 = p2.next;
            }
            temp = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
        }
        return sentinel.next;
    }


}
