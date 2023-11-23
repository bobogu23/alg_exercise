package com.alg.exercise.easy.topcode20220829;

/**
 * 检测环，
 * https://leetcode.cn/problems/linked-list-cycle-ii/?plan=leetcode_75&plan_progress=gb9pjkv
 *
 * 快慢指针
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode l1=  new ListNode(1);
        ListNode l2=  new ListNode(2);
        ListNode l3=  new ListNode(0);
        ListNode l4=  new ListNode(-4);
        l1.next = l2;
//        l2.next = l1;
//        l3.next = l4;
//        l4.next = l2;

        ListNode listNode = detectCycle(l1);
        if(listNode != null){
            System.err.println(listNode.val);
        }else {
            System.err.println("no cycle");
        }
    }


    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null){
            if(fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            slow = slow.next;
            if(slow.equals(fast)){
                ListNode p = head;
                while (!p.equals(slow)){
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return null;
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
