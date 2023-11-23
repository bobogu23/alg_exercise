package com.alg.exercise.easy;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * //双指针，第一个指针先走k步，然后两个指针一起往前走，直到第一个指针走完链表。
 *
 */
public class KthFromEnd {

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ListNode listNode = getKthFromEnd(node1, 3);
        listNode.printListNode();

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        int count = 0 ;
        while (first != null){
            first = first.next;
            count++;
            if(count > k){
                second = second.next;
            }
        }
        return second;
    }



}
