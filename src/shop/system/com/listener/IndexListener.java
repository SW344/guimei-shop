package com.listener;

import com.dao.Mapper.ProductMapper;
import com.entity.ProductInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class IndexListener implements ServletContextListener {

    // 项目启动时调用
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // 创建ProductService实例
        com.dao.ProductMapper productMapper = new ProductMapper();
        // 使用ProductService获取商品信息列表
        List<ProductInfo> productInfoList =  productMapper.selectAll();
        // 将商品信息列表存储在ServletContext中
        context.setAttribute("productInfoList", productInfoList);

        // 打印信息到日志，或者其他监控系统，以确认初始化完成
        System.out.println("商品信息已加载到ServletContext中。");
    }

    // 项目关闭时调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web应用程序已关闭。");
    }
}
