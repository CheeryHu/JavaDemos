package com.cheeryhu.leetcode;

import java.util.Stack;

public class Test20 {

    public static void main(String[] args){
        String s = "()";
        Test20 test20 = new Test20();
        boolean r = test20.isValid(s);
        System.out.println(r);
    }

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if(stack.size() == 0){
                stack.push(c);
            } else if ((c == '}' && stack.peek() == '{') || c == ']' && stack.peek() == '[' || (c == ')' && stack.peek() == '(')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}
