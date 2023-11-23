package com.alg.exercise.mid.topcode20221107;


public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        RemoveNthFromEnd r = new RemoveNthFromEnd();
        r.removeNthFromEnd2(l1,1);
        l1.printListNode();

    }


      static public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        //删除倒数第n个节点，要将倒数第n+1个节点指向 ，倒数n个节点的下一个节点
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int end = count - n;
        cur = sentinel;
        for (int i = 0; i < end; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        if (next != null) {
            cur.next = next.next;
        }
        return sentinel.next;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        //第一个指针1 先走n步，如果走到链表结尾则还剩 len-n 步，此时第二个指针2从head节点开始走，
        //指针1和指针2一起走len-n 步，则指针2所在的节点就是倒数第n-1个节点
        ListNode l1 = head;
        for (int i = 0; i < n; i++) {
            l1 = l1.next;
        }
        ListNode l2 = sentinel;
        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2.next != null) {
            l2.next = l2.next.next;
        }
        return sentinel.next;

    }
}
