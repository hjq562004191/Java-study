package kaohe.Servlet;

import kaohe.Service.LoginService;
import kaohe.Service.LoginServiceImpl;
import kaohe.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CookieServlet" , urlPatterns = "/ck")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        if (cookies!=null){
            String uid = "";
            for (Cookie c:cookies
                    ) {
                if (c.getName().equals("uid")){
                    uid = c.getValue();
                }
            }
            //校验uid是否存在
            if ("".equals(uid)){
                //请求转发
                req.getRequestDispatcher("page").forward(req,resp);
            }else{
                //校验uid用户信息
                //获取业务层对象
                LoginService ls = new LoginServiceImpl();
                User user = ls.checkUidservice(uid);
                if (user!=null){
                    //把user信息存入session
                    HttpSession hs = req.getSession();
                    hs.setAttribute("user", user);
                    //网页计数器自增
                    ServletContext sc = this.getServletContext();
                    if (sc.getAttribute("numes")!=null){
                        int numes = (int) sc.getAttribute("numes");
                        numes++;
                        sc.setAttribute("numes",numes);}
                    else {
                        sc.setAttribute("numes",1);
                    }
                    //重定向
                    resp.sendRedirect("main");
                    return;
                }else {
                    //请求转发
                    req.getRequestDispatcher("page").forward(req,resp);
                    return;
                }
            }
        }
        else{
            //请求转发
            req.getRequestDispatcher("page").forward(req,resp);
            return;
        }

    }
}
