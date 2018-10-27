package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "MyFilter" , urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化");
    }

    @Override
    public void destroy() {
//        System.out.println("销毁。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("执行");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");

        //判断session
//            HttpSession hs = ((HttpServletRequest) servletRequest).getSession();
//            if (hs.getAttribute("user") == null){
//                ((HttpServletResponse)servletResponse).sendRedirect("/login.jsp");

                filterChain.doFilter(servletRequest,servletResponse);


//        System.out.println("执行222");
    }
}
