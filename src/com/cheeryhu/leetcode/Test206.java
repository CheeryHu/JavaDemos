package com.cheeryhu.leetcode;

public class Test206 {

    public ListNode reverseList(ListNode head) {
        ListNode pReverseHead = head;
        ListNode pPre = null;
        ListNode pNode = head;

        while(pNode != null){
            ListNode pNext = pNode.next;
            if(pNext == null){
                pReverseHead = pNode;
            }
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReverseHead;
    }

}
