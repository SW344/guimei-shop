package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class BaseServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        getMethod(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        getMethod(req, resp);
    }

    private void getMethod(HttpServletRequest req, HttpServletResponse resp) {
        // 获取请求参数
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            throw new IllegalArgumentException("The 'action' parameter is required.");
        }

        // 尝试获取当前类的方法
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 检查方法是否可访问
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            // 调用方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("No such method found: " + e.getMessage(), e);
        } catch (Exception e) {
            // 抛出异常
            throw new RuntimeException("Error invoking method: " + e.getMessage(), e);
        }
    }
}
