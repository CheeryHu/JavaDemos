package com.cheeryhu.leetcode;

public class Test160 {

    public static void main(String[] args){

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lengthA = 0, lengthB = 0;
        while (headA != null) {
            lengthA++;
        }
        while (headB != null) {
            lengthB++;
        }
        int steps;
        if (lengthA > lengthB) {
            steps = lengthA - lengthB;
            while (steps-- != 0) {
                headA = headA.next;
            }
            return headA;
        } else {
            steps = lengthB - lengthA;
            while (steps-- != 0) {
                headB = headB.next;
            }
            return headB;
        }
    }
}
