package com.alg.exercise.new20231009hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
 * 该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
 * 其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
 * 并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
 * 那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * @author ben.gu
 */
public class CopyRandomList_28 {


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //遍历一遍原始链表，将每个节点放入map中，key为节点，value为节点的位置。
    // 同时拷贝节点，放入list中。
    //再次遍历原始链表，读取每个节点的random 属性指向的节点，找到节点的位置。同样拷贝的节点的random指向
    //list中指定位置的节点

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> nodeIndex = new HashMap<>();
        List<Node> list = new ArrayList<>();
        Node n = head;
        int index = 0;
        while (n != null) {
            nodeIndex.put(n, index);
            list.add(new Node(n.val));
            n = n.next;
            index++;
        }
        n = head;
        index = 0;
        while (n != null) {
            Node newNode = list.get(index);
            if(n.random != null){
                Integer randomIndex = nodeIndex.get(n.random);
                newNode.random = list.get(randomIndex);
            }

            if (index + 1 < list.size()) {
                newNode.next = list.get(index + 1);
            }
            n = n.next;
            index++;
        }
        return list.get(0);
    }

}
