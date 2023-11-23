package com.alg.exercise.easy;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 遍历每个链表,谁小谁放前面，需要用到第三个链表
 *
 */
public class CombineSortedList {

    public static void main(String[] args) {
        ListNode listNode = buildListNode1();
        ListNode listNode1 = buildListNode2();
        ListNode listNode2 = mergeTwoLists(listNode1, listNode);
        listNode2.printListNode();
    }

    public static ListNode buildListNode1(){
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(3,node4);
        ListNode node1 = new ListNode(1,node2);
        return node1;
    }

    public static ListNode buildListNode2(){
         ListNode node4 = new ListNode(4);
         ListNode node2 = new ListNode(2,node4);
        ListNode node1 = new ListNode(1,node2);
        return node1;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }
        return dummy.next;
    }


}
