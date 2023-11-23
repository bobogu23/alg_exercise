package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 找长度为k的子链表，然后反转子链表。需要指定链表的头节点和尾节点，用于反转子链表使用
 * <p>
 * k =2
 * sentinel -> 1 -> 2 => sentinel -> 2 -> 1
 * tail 指针用于往后移动k步，指定子链表的尾部节点
 * head 指针用于指定 子链表的头部节点，每次循环k步之前，head = tail
 * <p>
 * 用一个指针表示新链表的尾部节点指针， subListTail
 * <p>
 * tailnext = tail.next 用于指定下一次循环，tail需要指向的节点
 * <p>
 * sentinel -> 1 -> 2   -> 3 -> 4 ,
 * sentinel -> 2 -> 1
 * sentinel -> 2 -> 1   -> 4 -> 3
 * <p>
 * <p>
 * 如果最后一段子链表不足k个，subListTail.next = h
 *
 * <p>
 * 如何反转一个链表？递归
 *
 * @author ben.gu
 */
public class ReverseKGroup_27 {
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

        public void print() {
            System.err.println(val + " ");
            if (next != null) {
                next.print();
            }
        }
    }

    public static void main(String[] args) {
        //测试反转链表
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

//        ListNode l = reverseSubList(l1,l2);
//        l.print();

        ListNode h = reverseKGroup(l1, 3);
        h.print();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        ListNode h = tail;

        ListNode newHead = new ListNode(-1);
        ListNode newListTail = newHead;

        ListNode nextTail = null;

        for (int i = 1; ; i++) {
            if (i % k == 0) {
                //记录 tail 的下一个节点，用于遍历下一个子链表
                nextTail = tail.next;
                ListNode subList = reverseSubList(h, tail);
                newListTail.next = subList;
                //将新链表的tail指针移动到链表末尾
                while (newListTail.next != null) {
                    newListTail = newListTail.next;
                }

                h = nextTail;
                tail = nextTail;
                if (tail == null) {
                    break;
                }
            } else {
                if (tail == null || tail.next == null) {
                    break;
                }
                tail = tail.next;
            }
        }
        newListTail.next = h;

        return newHead.next;

    }

    private static ListNode reverseSubList(ListNode head, ListNode end) {
        if (head == end) {
            head.next = null;
            return head;
        }
        ListNode subHead = reverseSubList(head.next, end);
        head.next.next = head;
        head.next = null;
        return subHead;
    }


}
