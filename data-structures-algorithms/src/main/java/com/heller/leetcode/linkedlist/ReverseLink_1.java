package com.heller.leetcode.linkedlist;

public class ReverseLink_1 {
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode rev(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode revNode = rev(head.next);
        head.next.next = head;
        head.next = null;
        return revNode;
    }
}
