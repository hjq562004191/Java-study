package com.map.web.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.map.utils.JWTUtils;
import com.map.utils.JedisUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class AdminInterceptor implements HandlerInterceptor {

    private String[] INTERCEPT_URL = {"/register", "/login", "/util"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getServletPath();
        System.out.println(path);
        if (path.contains("/admin")) {
            for ( String url : INTERCEPT_URL) {
                if (path.contains(url)) {
                    return true;
                }
            }
        } else {
            return true;
        }
        // 处理token
        String token = request.getHeader("token");
        if (token == null) {
            request.getRequestDispatcher("/utils/adminNotLoginIn").forward(request, response);
            return false;
        } else {
            int id = 0;
            try {
                Map<String, Claim> map = JWTUtils.verifyToken(token);
                id = map.get("id").asInt();
                request.setAttribute("id", id);
                String jurisdiction = map.get("type").asString();
                if (!jurisdiction.equals("admin")) {
                    request.getRequestDispatcher("/utils/noJurisdiction").forward(request, response);
                    return false;
                }
            } catch (Exception e) {
                request.getRequestDispatcher("/utils/logonExpires").forward(request, response);
                return false;
            }
            // 在Redis中查询存储的token
            String sToken = JedisUtils.getToken("admin" + id);
            if (!token.equals(sToken)) {
                // 登录异常，需要强制下线
                request.getRequestDispatcher("/utils/loginException").forward(request, response);
            } else {
                return true;
            }
        }
        return false;
    }
}
