package com.cheeryhu.leetcode;

public class Test104 {

    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int rigth = maxDepth(root.right);
        return Math.max(left,rigth) + 1;
    }

}
