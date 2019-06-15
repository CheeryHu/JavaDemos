package com.cheeryhu.leetcode;

public class Test237 {

    // [4,5,1,9]
    //5


    public void deleteNode(ListNode node) {
        if(node == null){
            return ;
        }
        else if(node.next == null){
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }


}
