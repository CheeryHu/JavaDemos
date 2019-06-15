package com.cheeryhu.leetcode;

import java.util.Stack;

public class Test150 {



    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        int num1;
        int num2;
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (token.charAt(0)) {
                    case '+':
                        num1 += num2;
                        break;
                    case '-':
                        num1 -= num2;
                        break;
                    case '*':
                        num1 *= num2;
                        break;
                    case '/':
                        num1 /= num2;
                        break;
                }
                stack.push(num1);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
