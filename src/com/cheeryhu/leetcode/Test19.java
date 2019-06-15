package com.cheeryhu.leetcode;

public class Test19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }

        ListNode pAhead = head;
        ListNode pBehind = null;
        for (int i = 0; i < n + 1; i++) {
            if (pAhead.next != null) {
                pAhead = pAhead.next;
            } else {
                return null;
            }
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        pBehind = head;
        while (pAhead != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        pBehind.next = pBehind.next.next;

        return dummyHead.next;
    }
}
