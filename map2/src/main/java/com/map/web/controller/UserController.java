package com.map.web.controller;

import com.auth0.jwt.interfaces.Claim;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.pagehelper.PageInfo;
import com.map.domain.User;
import com.map.utils.JWTUtils;
import com.map.web.View.DetialView;
import com.map.web.View.SimpleView;
import com.map.web.model.ResultBuilder;
import com.map.web.model.ResultModel;
import com.map.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/register", method = POST)
    public ResultModel register(@Valid User user, BindingResult bindingResult) {
        // 如果注册的信息有问题
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError objectError : errors) {
                FieldError fieldError = (FieldError) objectError;
                String message = fieldError.getField();
                return ResultBuilder.getFailure(-1, message + ":" + fieldError.getDefaultMessage());
            }
        }
        return userService.register(user);
    }


    @RequestMapping(value = "/user/login", method = POST)
    public ResultModel login(String account, String password) throws Exception {
        return userService.login(account, password);
    }

    @GetMapping("/getUserMessageById")
    @JsonView(SimpleView.class)
    public ResultModel getUserMessageById(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("id");
        return userService.getUserMessageById(userId);
    }

    @GetMapping("/admin/users")
    @JsonView(DetialView.class)
    public ResultModel getUsers(int pageNo, int pageSize) {

        PageInfo<User> list = userService.getUsers(pageNo, pageSize);
        List<User> users = list.getList();
        System.out.println(list);
        if (!users.isEmpty()) {
            return ResultBuilder.getSuccess(users);
        } else {
            return ResultBuilder.getFailure(1, "该范围内没有用户");
        }
    }

    @RequestMapping(value = "/admin/userlock/{userId:\\d+}")
    public ResultModel lockUser(@PathVariable int userId) {
        return userService.lockedUser(userId);
    }

    @RequestMapping(value = "/admin/userunlock/{userId:\\d+}")
    public ResultModel unLockUser(@PathVariable int userId) {
        return userService.unLockUser(userId);
    }

    @PostMapping(value = "/user")
    @JsonView(SimpleView.class)
    public ResultModel getUserByName(String username) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            ResultBuilder.getFailure(1, "用户不存在");
        }
        return ResultBuilder.getSuccess(user);
    }

    protected Integer getUserIdFromToken(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getHeader("token");
        Integer userId = null;
        if (token != null) {
            try {
                Map<String, Claim> map = JWTUtils.verifyToken(token);
                userId = map.get("id").asInt();
            } catch (UnsupportedEncodingException e) {
                userId = null;
            } catch (Exception e) {
                request.getRequestDispatcher("/utils/logonExpires").forward(request, response);
                e.printStackTrace();
            }
        }
        return userId;
    }
}
