package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/?plan=leetcode_75&plan_progress=gb9pjkv
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * 输入：[1,2,3,4,5]
 * 1,1
 * 2,3,
 * 3,5
 * <p>
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 1,1
 * 2,3
 * 3,5
 * 4,null
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
public class MiddleNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        ListNode mid = middleNode(l1);
        mid.print();
    }

    //使用双指针，第一个指针一次移动一步，第二个指针一次移动两步

    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,
                 ListNode next) {
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
