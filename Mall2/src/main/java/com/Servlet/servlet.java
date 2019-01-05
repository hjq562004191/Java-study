package com.Servlet;

import com.POJO.Node;

import com.POJO.Road;
import com.Service.SelectAll;
import com.Service.SelectAllImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


@SuppressWarnings("all")
@WebServlet(name = "servlet",urlPatterns = "/main")
public class servlet extends HttpServlet {
    SelectAll sa = new SelectAllImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String oper = req.getParameter("oper");

        if ("find".equals(oper)){
            Findsomewhere(req,resp);
        }else if ("returnmain".equals(oper)){
            returnmain(req,resp);
        }else if ("direct".equals(oper)){
            Direct(req,resp);
        }else if ("select".equals(oper)){ //查询景点信息用的
            Selectname(req,resp);
        }else if ("select2".equals(oper)){//查询路线用的
            Selectname2(req,resp);
        }else if ("select3".equals(oper)){//删除Node的选择
            Selectname3(req,resp);
        }else if ("select4".equals(oper)){//删除Road的选择
            Selectname4(req,resp);
        }else if ("addNode".equals(oper)){
            AddNode(req,resp);
        }else if ("deletNode".equals(oper)){
            DeletNode(req,resp);
        }else if ("addRoad".equals(oper)){
            AddRoad(req,resp);
        }else if ("deletRoad".equals(oper)){
            DeletRoad(req,resp);
        }else if ("addRoad2".equals(oper)){
            addroad(req,resp);
        }


    }

    private void addroad(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SelectAll selectAll = new SelectAllImpl();
        List<Road> Roadlist = selectAll.selectAllRoad();
        List<Node> Nodelist = selectAll.selectAllNode();
        req.setAttribute("Roadlist",Roadlist);
        req.setAttribute("Nodelist",Nodelist);
        req.getRequestDispatcher("addRoad.jsp").forward(req,resp);
        return;
    }

    private void DeletRoad(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("deletRoadid"));
        int index = sa.deletRoad(id);

        if (index > 0){
            resp.sendRedirect("sucess.jsp");
            return;
        }
    }

    private void AddRoad(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Road road = new Road();
        road.setId(sa.selectAllRoad().size()+1);
        road.setFirst(Integer.parseInt(req.getParameter("addRoadfirst")));
        road.setLast(Integer.parseInt(req.getParameter("addRoadlast")));
        road.setWeight(Integer.parseInt(req.getParameter("addRoadweight")));

        int index = sa.addRoad(road);
        if (index > 0){
            resp.sendRedirect("sucess.jsp");
            return;
        }
    }

    private void DeletNode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("deletNodeid"));
        System.out.println(id);
        int index = sa.deletNode(id);

        if (index > 0){
            resp.sendRedirect("sucess.jsp");
            return;
        }
    }

    private void AddNode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Node node = new Node();
        node.setId(sa.selectAllNode().size()+1);
        node.setName(req.getParameter("addNodename"));
        node.setTouse(req.getParameter("addNodetouse"));

        System.out.println(sa.selectAllNode().size()+1);
        System.out.println(req.getParameter("addNodename"));
        System.out.println(req.getParameter("addNodetouse"));

        int index = sa.addNode(node);
        if (index == 1){
            resp.sendRedirect("sucess.jsp");
            return;
        }
    }

    private void Selectname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Node> Nodelist = sa.selectAllNode();
        req.setAttribute("Nodelist",Nodelist);
        req.getRequestDispatcher("findsomewhere.jsp").forward(req,resp);
        return;
    }

    private void Selectname2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Node> Nodelist = sa.selectAllNode();
        req.setAttribute("Nodelist",Nodelist);
        req.getRequestDispatcher("direct.jsp").forward(req,resp);
        return;
    }

    private void Selectname3(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Node> Nodelist = sa.selectAllNode();
        req.setAttribute("Nodelist",Nodelist);
        req.getRequestDispatcher("deletNode.jsp").forward(req,resp);
        return;
    }

    private void Selectname4(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Road> Roadlist = sa.selectAllRoad();
        List<Node> Nodelist = sa.selectAllNode();
        req.setAttribute("Roadlist",Roadlist);
        req.setAttribute("Nodelist",Nodelist);
        req.getRequestDispatcher("deletRoad.jsp").forward(req,resp);
        return;
    }

    private void Direct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        int start = Integer.parseInt(req.getParameter("a"));
        int end = Integer.parseInt(req.getParameter("b"));


        if (start != end) {

            //最短路径
            List<Road> Roadlist = sa.selectAllRoad();
            List<Node> Nodelist = sa.selectAllNode();

            int[] vetexes = new int[Nodelist.size()];
            for (int i = 0; i < Nodelist.size(); i++) {
                vetexes[i] = i+1;
            }

            Dijkstra graph = new Dijkstra(vetexes);

            for (Road r : Roadlist
                    ) {
                graph.addEdge(r.getFirst(), r.getLast(), r.getWeight());
                graph.addEdge(r.getLast(), r.getFirst(), r.getWeight());
            }
            Map<String, Object> map = graph.dijkstra(start, end);

            //节点最少路径
            BFS graph1 = new BFS();
            Stack<Integer> stack = graph1.fun(start-1,end-1);
            int k = stack.size();
            String direct2 = Nodelist.get(start-1).getName()+"->";
            int num = k+2;
            for (int i = 0; i < k; i++)
            {
                    direct2 = direct2  + Nodelist.get(stack.pop()).getName()+ "->";
            }

            direct2 = direct2 + Nodelist.get(end-1).getName();


            //全部路径
            AllRoads A = new AllRoads();
            String[] allRoads = new String[100];
                   allRoads = A.fun(start-1,end-1);

            req.setAttribute("allroads",allRoads);
            req.setAttribute("num",num);
            req.setAttribute("direct2",direct2);
            req.setAttribute("direct", map.get("direct"));
            req.setAttribute("directname", map.get("directname"));
            req.setAttribute("distance", map.get("distance"));
            req.getRequestDispatcher("showdirect.jsp").forward(req, resp);
            return;
        }else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
    }


    private void Findsomewhere(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectAll selectAll = new SelectAllImpl();
        List<Road> Roadlist = selectAll.selectAllRoad();
        List<Node> Nodelist = selectAll.selectAllNode();

        int id = Integer.parseInt(req.getParameter("nameselect"));

        if (Nodelist!=null){
            req.setAttribute("tempname",Nodelist.get(id-1).getName());
            req.setAttribute("tempid",id);
            req.setAttribute("temptouse",Nodelist.get(id-1).getTouse());
            req.getRequestDispatcher("showsomewhere.jsp").forward(req,resp);
            return;

        }
    }

    public void returnmain(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("Main.jsp");
        return;
    }
}
