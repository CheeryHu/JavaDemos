package com.cheeryhu.java.dataStructure.StackDemo;

import java.util.Iterator;

public class ArrayStack<Item> implements MyStack<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    @Override
    public MyStack<Item> push(Item item) {
        check();
        a[N++] = item;
        return this;
    }

    @Override
    public Item pop() throws Exception {
        if(isEmpty()){
            throw new Exception("stack is empty!");
        }
        Item item = a[--N];
        check();
        a[N] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            //返回逆序遍历的迭代器
            private int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };
    }

    /**
     * 调整数组大小，使得栈具有伸缩性
     */
    private void check() {
        if (N >= a.length) {
            resize(2 * a.length);
        } else if (N > 0 && N <= a.length / 4) {
            resize(a.length / 2);
        }
    }

    private void resize(int size) {
        Item[] tmp = (Item[]) new Object[size];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }
}
