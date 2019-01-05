package com.Servlet;

import com.POJO.Node;
import com.POJO.Road;
import com.Service.SelectAll;
import com.Service.SelectAllImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AllRoads {
    public Vertex[] vertexList; //存放点的集合
    public AllRoads(){

    }
    public AllRoads(int vertexNum){
        this.vertexNum=vertexNum;
        vertexList=new Vertex[vertexNum];
    }
    //点个数
    public int vertexNum;
    //边个数
    public int edgeLength;

    public void initVertext(int datas[]){
        for(int i=0;i<vertexNum;i++){
            Vertex vertext=new Vertex();
            vertext.data=datas[i];
            vertext.firstEdge=null;
            vertexList[i]=vertext;
            //System.out.println("i"+vertexList[i]);
        }
        boolean[] isVisited=new boolean[vertexNum];
        for(int i=0;i<isVisited.length;i++){
            isVisited[i]=false;
        }
    }
    //针对x节点添加边节点y
    public void addEdge(int x,int y,int weight){
        Edge edge=new Edge();
        edge.setVertexId(y);
        edge.setWeight(weight);
        //第一个边节点
//        System.out.println(vertexList.length);
        if(null==vertexList[x].firstEdge){
            vertexList[x].firstEdge=edge;
            edge.setNext(null);
        }
        //不是第一个边节点,则采用头插法
        else{
            edge.next=vertexList[x].firstEdge;
            vertexList[x].firstEdge=edge;
        }
    }
    //得到x的邻接点为y的后一个邻接点位置,为-1说明没有找到
    public int getNextNode(int x,int y){
        int next_node=-1;
        Edge edge=vertexList[x].firstEdge;
        if(null!=edge&&y==-1){
            int n=edge.vertexId;
            //元素还不在stack中
            if(!states.get(n))
                return n;
            return -1;
        }

        while(null!=edge){
            //节点未访问
            if(edge.vertexId==y){
                if(null!=edge.next){
                    next_node=edge.next.vertexId;
                    if(!states.get(next_node))
                        return next_node;
                }
                else
                    return -1;
            }
            edge=edge.next;
        }
        return -1;
    }
    //代表某节点是否在stack中,避免产生回路
    public Map<Integer,Boolean> states=new HashMap();
    //存放放入stack中的节点
    public Stack<Integer> stack=new Stack();

    //输出2个节点之间的输出路径
    public void visit(int x,int y) throws IOException {
        //初始化所有节点在stack中的情况
       for(int i=0;i<vertexNum;i++){
            states.put(i,false);
        }
        //stack top元素
        int top_node;
        //存放当前top元素已经访问过的邻接点,若不存在则置-1,此时代表访问该top元素的第一个邻接点
        int adjvex_node=-1;
        int next_node;
        stack.add(x);
        states.put(x,true);
        while(!stack.isEmpty()){
            top_node=stack.peek();
            //找到需要访问的节点
            if(top_node==y){
                //打印该路径
                printPath();
                adjvex_node=stack.pop();
                states.put(adjvex_node,false);
            }
            else{
                //访问top_node的第advex_node个邻接点
                next_node=getNextNode(top_node,adjvex_node);
                if(next_node!=-1){
                    stack.push(next_node);
                    //置当前节点访问状态为已在stack中
                    states.put(next_node,true);
                    //临接点重置
                    adjvex_node=-1;
                }
                //不存在临接点，将stack top元素退出
                else{
                    //当前已经访问过了top_node的第adjvex_node邻接点
                    adjvex_node=stack.pop();
                    //不在stack中
                    states.put(adjvex_node,false);
                }
            }
        }
    }
        static int num = 0;
        static String[] roads = new String[99];
    //打印stack中信息,即路径信息
       public void printPath() throws IOException {
           SelectAll selectAll = new SelectAllImpl();
           List<Node> Nodelist = selectAll.selectAllNode();

        StringBuilder sb=new StringBuilder();
        for(Integer i :stack){
            sb.append(Nodelist.get(i).getName()+"->");
        }
        sb.delete(sb.length()-2,sb.length());
           roads[num] = sb.toString();
           num++;
           System.out.println(sb.toString());
    }

    public static String[] fun(int start,int end)throws IOException {
        SelectAll selectAll = new SelectAllImpl();
        List<Node> Nodelist = selectAll.selectAllNode();
        List<Road> Roadlist = selectAll.selectAllRoad();
        AllRoads g=new AllRoads(Nodelist.size());
        int[] Node = new int[Nodelist.size()];
        for (int i = 0; i < Nodelist.size(); i++) {
            Node[i] = i+1;
        }
        g.initVertext(Node);
        for (int i = 0; i < Roadlist.size(); i++) {
            g.addEdge(Roadlist.get(i).getFirst()-1,Roadlist.get(i).getLast()-1,Roadlist.get(i).getWeight());
            g.addEdge(Roadlist.get(i).getLast()-1,Roadlist.get(i).getFirst()-1,Roadlist.get(i).getWeight());
        }
        g.visit(start,end);
        return roads;
    }

    static class Edge {
        //对应的点下表
        public int vertexId;
        //边的权重
        public int weight;
        //下一个边节点
        public Edge next;
    //getter and setter自行补充

        public int getVertexId() {
            return vertexId;
        }

        public void setVertexId(int vertexId) {
            this.vertexId = vertexId;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Edge getNext() {
            return next;
        }

        public void setNext(Edge next) {
            this.next = next;
        }
    }

    static class Vertex {
        //存放点信息
        public int data;
        //与该点邻接的第一个边节点
        public Edge firstEdge;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Edge getFirstEdge() {
            return firstEdge;
        }

        public void setFirstEdge(Edge firstEdge) {
            this.firstEdge = firstEdge;
        }
    }
}