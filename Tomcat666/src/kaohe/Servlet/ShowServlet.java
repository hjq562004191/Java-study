package kaohe.Servlet;

import kaohe.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShowServlet" , urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession hs = req.getSession();
        if (hs.getAttribute("user") == null){
            resp.sendRedirect("ck");
        }
        User u = (User) hs.getAttribute("user");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<h3>"+u.getUname()+"的个人信息</h3>");
        resp.getWriter().write("<hr>");
        resp.getWriter().write("序号:"+u.getUid()+"<br>");
        resp.getWriter().write("账号:"+u.getUname()+"<br>");
        resp.getWriter().write("密码:"+u.getPwd()+"<br>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
