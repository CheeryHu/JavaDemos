package com.cheeryhu.jike;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    /**
     * 广度优先搜索（BFS）
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];  // 用来记录已经被访问的顶点,避免顶点被重复访问
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<>();  // 存储已经被访问、但相连但顶点还没有被访问的顶点
        queue.add(s);
        int[] prev = new int[v];  // 记录搜索路径
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
