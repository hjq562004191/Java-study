package Login.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet" , urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");

        String str = req.getAttribute("str") == null ?"":(String) req.getAttribute("str");

        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<font color='red' size='15px'>"+str+"</font>");
        resp.getWriter().write("<form action='login' method='post'>");
        resp.getWriter().write("用户名:<input type='text' name = 'uname' value=''/></br>");
        resp.getWriter().write("密码:<input type='password' name = 'pwd' value=''/></br>");
        resp.getWriter().write("<input type='submit' value='登陆'/></br>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
