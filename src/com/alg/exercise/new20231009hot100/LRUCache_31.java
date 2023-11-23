package com.alg.exercise.new20231009hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * hashmap + 双向链表
 *
 * @author ben.gu
 */
public class LRUCache_31 {

    public static void main(String[] args) {
        //["LRUCache","put","put","put","put","get","get"]
        //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache_31 cache = new LRUCache_31(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.err.println(cache.get(1));
        System.err.println(cache.get(2));

    }
    private int capacity;

    private Map<Integer, Node> map = new HashMap<>();
    private Node dummy;

    private class Node {
        private int key;//用于删除map中的数据
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache_31(int capacity) {
        this.capacity = capacity;
        dummy = new Node(0, 0);//哨兵节点
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    //不存在直接返回-1，如果存在需要把数字移动到链表开头
    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    private Node getNode(int key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        //节点移动到链表开头。先从链表中删除这个节点，然后再插入到链表开头
        removeNode(node);
        insertToHead(node);
        return node;

    }

    //插入到链表开头,也就是插入到dummy节点之后.  <-> dummy <-> 1 <-> 2
    private void insertToHead(Node node) {
        //node 加入链表
        node.next = dummy.next;
        node.pre = dummy;
        //链表中原先的头节点 指针调整
        node.pre.next = node;
        node.next.pre = node;
    }

    //  a <-> x <-> b ,删除x
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }


    //不存在，放入map 和链表的头部。校验容量，超过capacity ，需要先删除链表末尾的节点
    //已经存在，替换旧值。需要把数字移动到链表开头
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
        } else {
            node.value = value;
            removeNode(node);
        }
        map.put(key, node);
        //将put节点放入链表开头
        insertToHead(node);
        //超过容量删除链表尾部节点
        if (map.size() > capacity) {
            Node tail = dummy.pre;
            map.remove(tail.key);
            removeNode(tail);
        }
    }
}
