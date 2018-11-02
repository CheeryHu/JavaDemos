package com.cheeryhu.search;

/**
 * 链表实现无序符号表
 * @param <Key>
 * @param <Value>
 */
public class ListUnorderedST<Key, Value> implements UnorderedST<Key, Value>{

    private Node first;

    private class Node{
        Key key;
        Value value;
        Node next;
        Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public int size() {
        int cnt = 0;
        Node cur = first;
        while(cur != null){
            cur = cur.next;
            cnt++;
        }
        return cnt;
    }

    @Override
    public Value get(Key key) {
        Node cur = first;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        Node cur = first;
        while (cur != null){
            if(cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        // 如果在链表中没有找到节点，则使用头插法插入一个新节点
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) {
        if(first == null){
            return;
        }
        if(first.key.equals(key)){
            first = first.next;
            return;
        }
        Node pre = first, cur = first.next;
        while (cur != null){
            if(cur.key.equals(key)){
                pre.next = cur.next;
                return;
            }
            pre = pre.next;
            cur = cur.next;
        }

    }
}













