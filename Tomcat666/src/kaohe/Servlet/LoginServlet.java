package kaohe.Servlet;


import kaohe.Service.LoginService;
import kaohe.Service.LoginServiceImpl;
import kaohe.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname = req.getParameter("uname");
//            uname = new String(uname.getBytes("iso8859-1"),"utf-8");
        String pwd = req.getParameter("pwd");
        //System.out.println(uname+":"+pwd);
        //处理请求信息
        //获取业务层对象
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginservice(uname,pwd);
        System.out.println(u);
        //响应处理结果
        if (u!=null)
        {
            //创建cookie信息实现三天免登陆
            Cookie c = new Cookie("uid",u.getUid()+"");
            c.setMaxAge(3*24*3600);
            c.setPath("/");
            resp.addCookie(c);
            //转发
            //req.getRequestDispatcher("main").forward(req,resp);
            //将用户数据存储到session中
            HttpSession hs = req.getSession();
            hs.setAttribute("user",u);
            //创建context对象
            ServletContext sc = this.getServletContext();
            if (sc.getAttribute("numes") != null) {
                int numes = (int) sc.getAttribute("numes");
                numes++;
                sc.setAttribute("numes", numes);
            }else {
                sc.setAttribute("numes", 1);
            }
            //重定向
            resp.sendRedirect("main");
            return;}
        else {
            req.setAttribute("str","用户名或密码错误！");
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }
    }
}
