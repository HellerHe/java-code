package com.heller.leetcode.linkedlist;

/**
 * 一、找到需要反转的部分反转后接入其中
 * 二、三指针穿针引线pre,curr,next
 * 三、递归
 */
public class ReverseLink_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        ListNode curr = pre.next;
        ListNode next;
        for (int i = left; i <right; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode partition = reverseBetween(node1, 1,2);
    }
}
