package com.cheeryhu.leetcode;

public class Test876 {

    public ListNode middleNode(ListNode head) {
        ListNode pSlow = head;
        ListNode pFast = head;

        while(pFast != null && pFast.next != null){
            pSlow = pSlow.next;
            pFast = pFast.next.next;
        }
        return pSlow;
    }
}
