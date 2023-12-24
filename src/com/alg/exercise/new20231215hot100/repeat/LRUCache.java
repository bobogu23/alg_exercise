package com.alg.exercise.new20231215hot100.repeat;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @Author: gu
 * @Date: 2023/12/24 上午8:52
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.err.println(lRUCache.get(1));;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.err.println(lRUCache.get(2));;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.err.println(lRUCache.get(1));;    // 返回 -1 (未找到)
        System.err.println(lRUCache.get(3));;    // 返回 3
        System.err.println(lRUCache.get(4));;    // 返回 4

    }


    private Node dummy;//哨兵节点，指向头尾节点
    private Map<Integer,Node> map;

    private int capacity;



    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity= capacity;
        map = new HashMap<>();
        dummy = new Node(-1,-1);

        dummy.next = dummy; //next指向 头节点
        dummy.pre = dummy;//pre指向尾节点

    }

    public int get(int key) {
        //判断是否存在
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        //存在移动到链表头结点
        //删除节点
        remove(node);
        //插入头节点
        putHead(node);
        return node.value;
    }

    // a <-> xx <-> b,删除xx
    private void remove(Node node ){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next=null;
        node.pre =null;
    }

    //     tail <->  dummy <-> head
    private void putHead(Node node){
        node.next = dummy.next;
        dummy.next.pre=node;
        dummy.next = node;
        node.pre = dummy;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.value = value;
            //删除节点
            remove(node);
        }else {
            node = new Node(key,value);
            map.put(key,node);
        }
//        //删除节点
//        remove(node);
        //插入头节点
        putHead(node);

        //如果插入，导致容量超过capacity 逐出最久未使用
        if(map.size()>capacity){
            removeTail();
        }
    }

    //    a <-> tail <->  dummy <-> head
    private void removeTail() {
        Node tail = dummy.pre;
        map.remove(tail.key);
        tail.pre.next=tail.next;
        tail.next.pre = tail.pre;
    }


}
