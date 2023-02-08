package com.heller.leetcode.linkedlist;

public class IntersectLink_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB) {
            //currA = currA == null ? headB : currA.next;
            //currB = currB == null ? headA : currB.next;
            if (currA == null) {
                currA = headB;
            } else {
                currA = currA.next;
            }
            if (currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
        }
        return currA;
    }
}
