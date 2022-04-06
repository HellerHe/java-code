package com.heller;

import java.util.HashMap;

public class LRUWithDoubleLinkedList<K, V> {

    class Node<K,V> {
        private K k;
        private V v;
        private Node<K, V> next;
        private Node<K, V> pre;

        public Node() {
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    class DoubleLinkedList<K,V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        public void addHead(Node<K,V> node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            head.next = node.next;
            node.next.pre = head;
            node.next = null;
            node.pre = null;
        }

        public Node<K, V> getLast() {
            return tail.pre;
        }
    }

    private int capacity;
    private HashMap<K, Node<K, V>> map;
    private DoubleLinkedList<K, V> doubleLinkedList;

    public LRUWithDoubleLinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            return null;
        } else {
            Node<K, V> node = map.get(key);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
            return node.v;
        }
    }

    public void put(K k, V v) {
        if (map.containsKey(k)) {
            Node<K, V> node = map.get(k);
            node.v = v;
            map.put(k, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> last = doubleLinkedList.getLast();
                map.remove(last.k);
                doubleLinkedList.removeNode(last);
            }
            Node<K, V> node = new Node<>(k,v);
            map.put(k, node);
            doubleLinkedList.addHead(node);
        }
    }

    public static void main(String[] args) {
        LRUWithDoubleLinkedList<Integer, Integer> cache = new LRUWithDoubleLinkedList<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.map.keySet());
        cache.put(3, 3);
        System.out.println(cache.map.keySet());
        cache.put(3, 3);
        System.out.println(cache.map.keySet());
        cache.put(5, 5);
        System.out.println(cache.map.keySet());
    }
}
