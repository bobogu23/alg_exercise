package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 双指针，p1,p2,
 * 哨兵节点
 * p1从哨兵节点开始，先走2步，交换 p1 与 p2.next的节点。
 * 交换完成后，p2 挪到p1位置，p1继续先走2步
 * sentinel -> 1  -> 2  -> 3
 * p2          p1
 * <p>
 * <p>
 * <p>
 * p2.next.next = p1.next
 * <p>
 * 终止条件 , p1.next == null || p1.next.next == null
 *
 * @author ben.gu
 */
public class SwapPairs_26 {

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

    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode p1 = sentinel;
        ListNode p2 = sentinel;
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2.next.next = p1.next;
            p1.next = p2.next;
            p2.next = p1;
            p1 = p1.next;
            p2 = p1;
        }
        return sentinel.next;
    }

}
