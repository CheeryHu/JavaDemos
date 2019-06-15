package com.cheeryhu.leetcode;

import java.util.Stack;

public class Test32 {

    /**
     * 栈
     * @param s
     * @return
     */
    public int longestValidParentheses(String s){
        if(s == null || s.length() < 2){
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    //右括号时 若栈空
                    start = i + 1;
                }else {
                    //取出一个配对的括号
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i - start + 1);
                    }else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
