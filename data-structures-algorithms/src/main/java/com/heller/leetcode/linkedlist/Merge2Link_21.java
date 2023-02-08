package com.heller.leetcode.linkedlist;

public class Merge2Link_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode large = new ListNode(0);
        ListNode pre = large;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return large.next;
    }

    //终止条件：当两个链表都为空时，表示我们对链表已合并完成。
    //如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else{
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }
}
