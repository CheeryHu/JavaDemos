package com.cheeryhu.jike.nodirection;

import java.util.LinkedList;

public class Graph { // 无向图
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
//        adj[t].add(s);
    }

    int count = 0; // 全局变量或者类成员变量


    public void dfs7(int s, int t, int steps){
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, prev, steps, steps, true);
        System.out.println(count);
    }


    public void dfs6(int s, int t, int steps) {
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, prev, steps, steps, false);
        System.out.println(count);
    }

    private void recurDfs(int w, int t, int[] prev, int maxSteps,int steps, boolean exactly) {
        if (steps < 0) {
            return;
        }

        if (exactly) {
            if (w == t && steps != maxSteps && steps == 0) {
                count++;
            }
        } else if (w == t && steps != maxSteps && steps >= 0) {
            count++;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            prev[q] = w;
            recurDfs(q, t, prev, maxSteps, steps - 1, exactly);
        }
    }



    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
