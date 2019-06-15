package com.cheeryhu.leetcode;

import java.util.Stack;

public class Test {

    public int longestValidParentheses(String s) {
        int[] mark = new int[s.length() + 1];
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //左括号则进栈
            if (c == '(') {
                stack.push(i);
            }
            //右括号
            else {
                //没有与之匹配的左括号，抛弃，继续向前
                if (stack.isEmpty()) {

                }
                //有左括号
                else {
                    mark[stack.pop()] = 1;
                    mark[i] = 1;
                }
            }
        }

        int leftIndex = -1;
        for (int i = 0; i < mark.length; i++) {
            //左侧开始
            if (leftIndex == -1 && mark[i] == 1) {
                leftIndex = i;
            }

            //右侧结束
            if (leftIndex != -1 && mark[i] == 0) {
                ret = Math.max(ret, i - leftIndex);
                leftIndex = -1;
            }
        }

        return ret;
    }


    private class CharacterAndIndex {
        private final char c;
        private final int i;

        public CharacterAndIndex(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

}
