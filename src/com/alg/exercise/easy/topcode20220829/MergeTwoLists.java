package com.alg.exercise.easy.topcode20220829;

import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;

/**
 * 合并两个有序列表
 * https://leetcode.cn/problems/merge-two-sorted-lists/?plan=leetcode_75&plan_progress=gb9pjkv
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list12 = new ListNode(2);
        ListNode list14 = new ListNode(4);
        list1.next = list12;
        list12.next = list14;

        ListNode list2 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        ListNode list23 = new ListNode(4);
        list2.next = list22;
        list22.next = list23;

        ListNode listNode = mergeTwoLists(list1, list2);
        listNode.print();

        System.err.println("==================");
         list1 =null;
         list2 =new ListNode(0);
         listNode = mergeTwoLists(list1, list2);
         listNode.print();

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //遍历两个链表中的每个节点，较小的节点方前面
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode head  = new ListNode() ;
        ListNode p  = head;
        while (l1 != null && l2 != null){
              if(l1.val < l2.val){
                  p.next = l1;
                  l1 = l1.next;
              }else {
                  p.next = l2;
                  l2 = l2.next;
              }
              p = p.next;
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        return head.next;
    }

    public  static class ListNode {
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

        public void print(){
            System.err.println(val);
            if(next != null){
                next.print();
            }
        }
    }
}
