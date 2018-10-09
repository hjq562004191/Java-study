package kaohe.Servlet;

import kaohe.User;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Mainservlet" , urlPatterns = "/main")
public class Mainservlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
        User u = (User) hs.getAttribute("user");

        ServletContext sc = this.getServletContext();
        int numes = (int) sc.getAttribute("numes");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("浏览次数为:"+numes);
        resp.getWriter().write("<br>");
        resp.getWriter().write("<h3>欢迎"+u.getUname()+"使用学生管理系统</h3>");
        resp.getWriter().write("<hr>");
        resp.getWriter().write("<form action='show' method='get'>");
        resp.getWriter().write("<input type='submit' value='查看个人信息'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
