package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 位置从1开始
 * <p>
 * 解法1：使用for循环，遍历的时候计数，
 * <p>
 * 解法2：使用递归。
 * 2.1 先写出反转前n个位置节点的方法 reverseN（head,n）
 * <p>
 * <p>
 * 2.2 写出反转 m到n的位置节点的方法 reverseBetween(head,m,n)
 * reverseBetween 中的递归结束条件就是 m=1的时候，使用reverseN(head,n)，求出反转前n个位置的节点后的链表。
 */
public class ReverseLinkedList2_11 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseLinkedList2_11 r = new ReverseLinkedList2_11();

        ListNode listNode = r.reverseBetween(l1,2,4);
        listNode.print();


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        //如果是以 head.next 为起点，则反转位置left-1 到 位置right-1 的链表。一直找到left-1 = 1时的head节点，
        //也就是找到了要反转的起始节点，开始做反转操作。反转完成之后，只需要将位置1到left-1 的节点串连起来即可。
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;

    }


    /**
     * 反转前n个节点
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        //后继节点
        if (n == 1) {
            //记录最后一个要反转节点的后继节点，做为反转后链表的尾节点的next节点.
            // 比如链表 1->2->3->4->5,反转前3个节点，最终结果 3->2->1  ->4->5.
            //当n=1 ，也就是节点3时，记录 节点4。反转后的最后一个节点 也就是节点1 的next节点 就是节点4
            successor = head.next;
            return head;
        }
        //1->2->3->4->5 , head是节点1，以head.next 节点做为起始节点，反转2个节点。
        //反转后  1->  2<-3 4->5。 last =节点3， 节点2的next节点需要设置成节点1，也就是head。
        //head节点的next节点要设置成节点4，也就是successor后继节点

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.err.print(val + ",");
            if (this.next != null) {
                this.next.print();
            }
        }
    }
}
