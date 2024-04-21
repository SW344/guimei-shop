package com.controller;

import com.entity.UserInfo;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 用户事件
 */
public class User extends BaseServlet{

    UserService userService = new UserServiceImpl();
    /**
     * 注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(req.getParameter("username"));
            userInfo.setPassword(req.getParameter("password"));
            userInfo.setEmail(req.getParameter("email"));
            userInfo.setGender(req.getParameter("gender"));
            userInfo.setHobby(req.getParameter("hobby"));

            Boolean flag = userService.register(userInfo);
            if (!flag){
                throw new Exception("注册失败");
            }
            req.getSession().setAttribute("user", userInfo);
            // 返回登录成功界面
            req.getRequestDispatcher("/register_success.jsp").forward(req, resp);
        }catch (Exception e){
            req.getRequestDispatcher("/register_fail.jsp").forward(req, resp);
        }

    }

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(req.getParameter("username"));
            userInfo.setPassword(req.getParameter("password"));
            UserInfo user = (UserInfo) userService.login(userInfo);
            if (user == null){
                throw new Exception("登录失败");
            }
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/login_success.jsp").forward(req, resp);
        }catch (Exception e){
            req.getRequestDispatcher("/login_fail.jsp").forward(req, resp);
        }
    }


}
