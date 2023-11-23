package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;


        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        ListNode l3 = a.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.err.println(l3.val);
            l3 = l3.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //从第一个节点开始相加，定义一个变量存储进位的数字，每次相同位置上的节点相加时 加上进位的数字。最后如果进位数字不为0，则放入单独的节点
        int temp = 0;
        ListNode sentinel = new ListNode();
        ListNode cur = sentinel;
        while (l1 != null || l2 != null) {
            int res = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + temp;
            temp = res / 10;
            ListNode n = new ListNode(res % 10);
            cur.next = n;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (temp != 0) {
            cur.next = new ListNode(temp);
        }
        return sentinel.next;
    }

    public static class ListNode {
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
}
