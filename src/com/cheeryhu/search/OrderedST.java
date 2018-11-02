package com.cheeryhu.search;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>, Value> {

    int size();

    void put(Key key, Value value);

    Value get(Key key);

    Key min();

    Key max();

    /**
     * 排名函数
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 返回符合l<=key<=h的所有键的集合
     * @param l
     * @param h
     * @return
     */
    List<Key> keys(Key l, Key h);
}
