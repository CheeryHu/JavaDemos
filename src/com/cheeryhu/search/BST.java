package com.cheeryhu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value>{

    protected Node root;

    protected class Node{
        Key key;
        Value val;
        Node left;
        Node right;
        //以该节点为根的子树节点总数
        int N;
        //红黑树中使用
        boolean color;

        Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if(x == null)
            return 0;
        return x.N;
    }

    protected void recalculateSize(Node x){
        x.N = size(x.left) + size(x.right) + 1;
    }

    /**
     * 当插入的键不存在树中，需要创建一个新节点，并且更新上层节点的链接使得该节点正确链接到树中
     * @param key
     * @param value
     */
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            x.val = value;
        }else if(cmp < 0){
            x.left = put(x.left, key, value);
        }else {
            x.right = put(x.right, key, value);
        }
        recalculateSize(x);
        return x;
    }

    /**
     * 如果树是空的，则查找未命中；
     * 如果被查找的键和根节点的键相等，查找命中；
     * 否则递归地在子树中查找：如果被查找的键较小就在左子树中查找；否则在右子树中农查找
     * @param key
     * @return
     */
    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x.val;
        }else if(cmp < 0){
            return get(x.left, key);
        }else
            return get(x.right, key);
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x){
        if(x == null){
            return null;
        }
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        return null;
    }

    /**
     * 返回key的排名
     * 如果键和根节点的键相等，返回左子树的节点数
     * 如果小于，递归计算在左子树中的排名
     * 如果大于，递归计算在右子树中的排名，加上左子树的节点数，再加上1（根节点）
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x){
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return size(x.left);
        else if (cmp < 0)
            return rank(key, x.left);
        else
            return 1 + size(x.left) + rank(key, x.right);
    }

    /**
     * 利用二叉查找树中序遍历的结果为递增的特点
     * @param l
     * @param h
     * @return
     */
    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h){
        List<Key> list = new ArrayList<>();
        if(x == null){
            return list;
        }
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if(cmpL < 0){
            list.addAll(keys(x.left, l, h));
        }
        if (cmpL < 0 && cmpH >= 0){
            list.add(x.key);
        }
        if (cmpH > 0){
            list.addAll(keys(x.right, l, h));
        }
        return list;
    }

    /**
     * 小于等于键的最大键
     * 如果键小于根节点的键，那么floor(key)一定在左子树中
     * 如果键大于根节点的键，需要先判断右子树中是否存在floor(key)，如果存在就找到，否则根节点就是floor(key)
     * @param key
     * @return
     */
    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    /**
     * 令指向最小节点的链接指向最小节点的右子树
     */
    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    /**
     * 如果待删除的节点只有一个子树，那么只需要让指向待删除节点的链接指向唯一的子树即可
     * 否则，让右子树的最小节点替换该节点
     * @param key
     */
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, key);
        }else if (cmp > 0){
            x.right = delete(x.right, key);
        }else {
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        recalculateSize(x);
        return x;
    }

}




















