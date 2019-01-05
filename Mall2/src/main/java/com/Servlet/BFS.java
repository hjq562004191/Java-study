package com.Servlet;

import com.POJO.Node;
import com.POJO.Road;
import com.Service.SelectAll;
import com.Service.SelectAllImpl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    final static int INF = 100000;
    final int max = 100;
    int[] vexs = new int[max]; //存放顶点的数组
    int[][] edges = new int[max][max]; //存放边的数组

    /*
     * 创建邻接矩阵
     */
    public void createGraph(BFS graph , int[][] A, int[] vs) {
        vexs = vs;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A.length;j++) {
                graph.edges[i][j] = A[i][j];
            }
        }

    }

    public int getFirst(BFS graph, int v) {
        for(int i=0;i<graph.vexs.length;i++) {
            if (graph.edges[v][i]==1) {
                return i;
            }
        }
        return -1;
    }

    public int getNext(BFS graph , int v, int k) {
        for(int i=k+1;i<graph.vexs.length;i++) {
            if (graph.edges[v][i] == 1) {
                return i;
            }
        }
        return -1;
    }
    static int[] pre = new int[100]; //记录每个节点恶的前驱
    public void BFS(BFS graph, int v, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int next;
        queue.add(v);
        pre[v] = v;
        visited[v]=1;
        while (!queue.isEmpty()) {
            next=queue.remove();
            System.out.print(next+" ");
            int vex = graph.getFirst(graph, next);

            while (vex!=-1) {
                if (visited[vex]==0) {
                    pre[vex] = next;
                    queue.add(vex);
                    visited[vex]=1;
                }
                vex=graph.getNext(graph, next, vex);
            }
        }

    }


    public Stack<Integer> fun(int strat, int end) throws IOException {
        SelectAll selectAll = new SelectAllImpl();
        List<Node> Nodelist = selectAll.selectAllNode();
        List<Road> Roadlist = selectAll.selectAllRoad();
        int[] vs  = new int[99];
        int[][] A = new int[99][99];
        for (int i = 0; i < Nodelist.size(); i++) {
            for (int j = 0; j < Nodelist.size(); j++) {
                A[i][j] = INF;
            }
        }
        for (int i = 0; i < Roadlist.size(); i++) {
            A[Roadlist.get(i).getFirst()-1][Roadlist.get(i).getLast()-1] = 1;
            A[Roadlist.get(i).getLast()-1][Roadlist.get(i).getFirst()-1] = 1;
        }

        BFS graph = new BFS();
        graph.createGraph(graph, A, vs);
        int[] visited1 = new int[100];

        graph.BFS(graph, strat, visited1);


        System.out.println();
        System.out.println();
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        k = pre[end];
        stack.push(k);
//        System.out.println(k);
        boolean f= true;
        while (f){
            if (pre[k]!=strat){
                stack.push(pre[k]);
//                System.out.println(pre[k]);
                k = pre[k];
            }else {
                f = false;
            }
        }

        return stack;
    }

}