package com.alg.exercise.easy;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 *  * 输入：head = [1,2]
 *  * 输出：[2,1]
 *
 *   *  * 输入：head = []
 *  *  * 输出：[]
 *
 *
 * 迭代法：
 * 前后两个指针，遍历链表，将每个node指向前一个node
 *
 */
public class LinkedListReserve {

    public static void main(String[] args) {
        //测试
//        ListNode listNode = buildListNode1();
        ListNode listNode = buildListNode2();
//        ListNode reversedList = reverseList(listNode);
        ListNode reversedList = reverseList1(listNode);
        reversedList.printListNode();
    }

    public static ListNode buildListNode1(){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        return node;
    }

    public static ListNode buildListNode2(){
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
         return node1;
    }


    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            //临时变量 保存 当前节点的next节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //递归，一直到最后一个节点
        ListNode listNode = reverseList1(head.next);
        //递归到最后一个节点，不需要反转。退出递归，回到最后一个节点last的上一个节点pre，将last 节点的next指向pre.
        //pre节点的next 不再指向 last节点
        head.next.next = head;//last->pre
        head.next = null;
        return listNode;

    }
}

class ListNode {
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

    public void printListNode(){
        StringBuffer sb = new StringBuffer();
        sb.append(val).append(",");
        ListNode next = this.next;
        while (next != null){
            sb.append(next.val).append(",");
            next = next.next;
        }
        System.err.println(sb.substring(0,sb.length()-1));
    }
}
