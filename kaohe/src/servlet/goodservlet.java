package servlet;

import service.goodservice;
import service.goodserviceImpl;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "goodservlet" , urlPatterns = "/good")
public class goodservlet extends HttpServlet {
    goodservice gs = new goodserviceImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String oper = req.getParameter("oper");
        if (oper.equals("add")){
            addgood(req,resp);
        }else if (oper.equals("dele")){
            delegood(req,resp);
        }else if (oper.equals("change")){
            changegood(req,resp);
        }else if (oper.equals("read")){
            readgood(req,resp);
        }

    }

    private void changegood(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String cid = req.getParameter("cid");
        int id = Integer.valueOf(cid);
        String name = req.getParameter("gname");
        String type =  req.getParameter("gtype");
        String chandi =  req.getParameter("gchandi");
        String date =  req.getParameter("gdate");
        String num1 = req.getParameter("gnum");
        int num = Integer.valueOf(num1);
        User user = new User();
        user.setId(id);
        user.setGname(name);
        user.setType(type);
        user.setChandi(chandi);
        user.setDate(date);
        user.setNum(num);

        System.out.println(name+" "+type);
        gs.change(user);

        req.getRequestDispatcher("chance.jsp").forward(req,resp);
    }

    private void delegood(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        gs.dele(id);

        resp.sendRedirect("chance.jsp");
    }

    private void readgood(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = gs.read();

        if (list!=null){

            req.setAttribute("list",list);

            req.getRequestDispatcher("read.jsp").forward(req,resp);
        }

    }

    private void addgood(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("gname");
        String type =  req.getParameter("gtype");
        String chandi =  req.getParameter("gchandi");
        String date =  req.getParameter("gdate");
        String num1 = req.getParameter("gnum");
        int num = Integer.valueOf(num1);
        User user = new User();
        user.setGname(name);
        user.setType(type);
        user.setChandi(chandi);
        user.setDate(date);
        user.setNum(num);

        gs.add(user);

        req.getRequestDispatcher("chance.jsp").forward(req,resp);
    }

}
