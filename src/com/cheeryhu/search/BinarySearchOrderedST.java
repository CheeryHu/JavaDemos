package com.cheeryhu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找实现有序符号表
 * 使用一对平行数组，一个存储键，一个存储值
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchOrderedST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value>{

    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchOrderedST(int capacity){
        keys =(Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        // 如果找到已经存在的节点键位Key,就更新这个节点
        if(index < N && keys[index].compareTo(key) == 0){
            values[index] = value;
            return;
        }

        // 否则在数组中插入新的节点，需要将插入位置之后的节点都往后移一位
        for(int j = N; j > index; j--){
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[index] = key;
        values[index] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        int index = rank(key);
        if(index < N && keys[index].compareTo(key) == 0){
            return values[index];
        }
        return null;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public int rank(Key key) {
        int l = 0, h = N - 1;
        while (l <= h){
            int m = l + (h - 1) / 2;
            int cmp = key.compareTo(keys[m]);
            if(cmp == 0){
                return m;
            }else if(cmp < 0){
                h = m - 1;
            }else {
                l = m + 1;
            }
        }
        return l;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        int index = rank(l);
        List<Key> list = new ArrayList<>();
        while(keys[index].compareTo(h) <= 0){
            list.add(keys[index]);
            index++;
        }
        return list;
    }
}












