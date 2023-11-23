package com.alg.exercise.easy.topcode20220829;

public class OddEvenList {

    public static void main(String[] args) {
         ListNode head = new  ListNode(1);
         ListNode n2 = new  ListNode(2);
         ListNode n3 = new  ListNode(3);
         ListNode n4 = new  ListNode(4);
         ListNode n5 = new  ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = oddEvenList(head);
        listNode.print();
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode l1 = new ListNode(0,null);
        ListNode l2 = new ListNode(0,null);
        ListNode cur = head;
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;

        int i = 1;
        while (cur != null){
            if(i % 2 == 0){
                l2Cur.next = cur;
                l2Cur = l2Cur.next;
            }else{
                l1Cur.next = cur;
                l1Cur= l1Cur.next;
            }
            cur = cur.next;
            l2Cur.next =null;
            l1Cur.next =null;
            i++;
        }
        l1Cur.next = l2.next;

        return l1.next;

    }

    public static class ListNode {
        int val;
         ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,  ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.err.println(val);
            if (next != null) {
                next.print();
            }
        }
    }
}
