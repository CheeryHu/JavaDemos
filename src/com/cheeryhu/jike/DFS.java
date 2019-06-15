package com.cheeryhu.jike;

import com.cheeryhu.jike.nodirection.Graph;

public class DFS {

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
        graph.addEdge(2,4);
        graph.addEdge(3,2);
        graph.addEdge(0,4);
//        graph.dfs6(2,2,3);
        graph.dfs7(0,2,4);

    }

}
