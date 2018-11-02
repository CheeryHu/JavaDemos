package com.cheeryhu.niuke;

import java.util.*;
import java.util.logging.Level;

public class Test {

    public static final String STRINGA = "This is nowcoder";
    public static final String STRINGB = "is This nowcoder";

    public static void main(String[] args){

//        boolean result = checkSam(STRINGA, STRINGB);
//        replaceSpace("Mr John Smith",13);
        String result = zipString("aabcccccaaac");
        System.out.println(result);
    }


    class ListNode{
        ListNode p;
        String value;
    }

    public boolean removeNode(ListNode pNode) {

        return true;
    }



    /**
     * 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
     *
     * 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
     * @param mat
     * @param n
     * @return
     */
    public int[][] transformImage(int[][] mat, int n) {

        return mat;
    }


    /**
     * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
     *
     * 给定一个string iniString为待压缩的串(长度小于等于10000)，保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
     *
     * @param iniString
     * @return
     */
    public static String zipString(String iniString) {
        if(null == iniString){
            return null;
        }
        char[] chars = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1 ; i < chars.length; i++){
            if(chars[i] != chars[i-1]){
                sb.append(chars[i-1]).append(count);
                count = 1;
            }else{
                count++;
            }
        }
        sb.append(chars[chars.length-1]).append(count);
        return sb.toString().length() < iniString.length() ? sb.toString() : iniString;
    }


    /**
     * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
     *
     * @param iniString
     * @param length
     * @return
     */
    public static String replaceSpace(String iniString, int length) {
        if(null == iniString){
            return iniString;
        }
        char[] chars = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: chars){
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /**
     * 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格。
     *
     * 给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。保证两串的长度都小于等于5000。
     * @param stringA
     * @param stringB
     * @return
     */
    public static boolean checkSam(String stringA, String stringB) {
        if(null == stringA || null == stringB || stringA.length() != stringB.length()){
            return false;
        }

        char[] charA = stringA.toCharArray();
        char[] charB = stringB.toCharArray();
        Arrays.sort(charA);
        Arrays.sort(charB);
        return Arrays.equals(charA, charB);
    }



    /**
     * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
     *
     * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
     * @param iniString
     * @return
     */
    public boolean checkDifferent(String iniString){
        if(null == iniString){
            return true;
        }
        char[] chars = iniString.toCharArray();
        for (int i = 0; i < chars.length; i++){
            for (int j = i + 1 ; j < chars.length; j++){
                if(chars[i] == chars[j]){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
     *
     * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
     * @param iniString
     * @return
     */
    public String reverseString(String iniString){
        if(null == iniString){
            return null;
        }
        char[] chars = iniString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i --){
            sb.append(chars[i]);
        }
        return sb.toString();
    }


}
