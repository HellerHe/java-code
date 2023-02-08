package com.heller.leetcode.linkedlist;

public class PartitionLink_86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode smallSentinel = new ListNode(0); //哨兵
        ListNode bigSentinel = new ListNode(0);
        ListNode small = smallSentinel;
        ListNode big = bigSentinel;
        while (head != null) {
            if (head.val <x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigSentinel.next;
        return smallSentinel.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode partition = partition(node1, 2);
    }
}
