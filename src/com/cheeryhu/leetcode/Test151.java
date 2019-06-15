package com.cheeryhu.leetcode;

public class Test151 {

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--){
            if(!arr[i].equals(" ") && arr[i].length() > 0){
                if(sb.length() > 0){
                    sb.append(" ");
                }
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

}
