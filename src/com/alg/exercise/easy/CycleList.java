package com.alg.exercise.easy;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递  。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环  ，则返回 true 。 否则，返回 false 。
 *
 * 快慢指针，一个指针每次走一步，一个指针每次走两步
 
 */
public class CycleList {

    public static void main(String[] args) {
        ListNode head = buildListNode2();
        System.err.println(hasCycle(head));
    }

    public static ListNode buildListNode2(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        node5.next = node2;
        return node1;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}

