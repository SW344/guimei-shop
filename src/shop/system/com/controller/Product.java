package com.controller;

import com.entity.ShoppingInfo;
import com.entity.ProductInfo;
import com.entity.ShoppingCartInfo;
import com.entity.UserInfo;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



public class Product extends BaseServlet{

    ProductService productService = new ProductServiceImpl();

    /**
     * 显示商品
     * @param req  请求
     * @param resp 响应
     * @throws ServletException
     * @throws IOException
     */
    public void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        List<ProductInfo> productInfoList = productService.getProductByCategory(category);
        req.setAttribute("productInfoList",productInfoList);
        req.getRequestDispatcher("/catlist.jsp").forward(req,resp);
    }

    /**
     *商品详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        ProductInfo productInfo = productService.getProductById(id);
        req.setAttribute("productInfo",productInfo);
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
    /**
     *  购物
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void buy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            UserInfo userInfo = (UserInfo) req.getSession().getAttribute("user");
            List<ShoppingCartInfo> shoppingCartInfoList = productService.getCart2ByuserId(userInfo.getId());
            ShoppingInfo buyInfo = new ShoppingInfo();
            buyInfo.setConsignee(req.getParameter("username"));
            buyInfo.setAddress(req.getParameter("address"));
            buyInfo.setPhone(req.getParameter("code")+req.getParameter("telnumber")+req.getParameter("branchnumber"));
            for (ShoppingCartInfo shoppingCartInfo : shoppingCartInfoList){
                ShoppingInfo buyInfo1 = new ShoppingInfo();
                buyInfo1.setConsignee(buyInfo.getConsignee());
                buyInfo1.setAddress(buyInfo.getAddress());
                buyInfo1.setPhone(buyInfo.getPhone());
                buyInfo1.setUserId(shoppingCartInfo.getUserId());
                buyInfo1.setProductId(shoppingCartInfo.getProductId());
                productService.buy(shoppingCartInfo,buyInfo1);
            }

            req.getRequestDispatcher("/buy_success.jsp").forward(req,resp);
        }catch (Exception e){
            req.getRequestDispatcher("/buy_fail.jsp").forward(req,resp);
        }
    }

    /**
     *  搜索商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void search (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        ProductInfo productInfo = productService.selectByKeyWord(keyword);
        req.setAttribute("productInfo",productInfo);
        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }

    /**
     * 显示购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo userInfo = (UserInfo) req.getSession().getAttribute("user");
        if(userInfo == null){
            req.getRequestDispatcher("/access_fail.jsp").forward(req,resp);
        }else{
            List<ProductInfo> productInfoList = productService.getCartByuserId(userInfo.getId());
            List<ShoppingCartInfo> shoppingCartInfoList = productService.getCart2ByuserId(userInfo.getId());
            req.setAttribute("shoppingCartInfoList",shoppingCartInfoList);
            req.setAttribute("productInfoList",productInfoList);
           req.getRequestDispatcher("/buy.jsp").forward(req,resp);
       }
}

/**
     *  添加购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserInfo userInfo = (UserInfo) req.getSession().getAttribute("user");
        Integer id = Integer.parseInt(req.getParameter("id"));
        productService.addShoppingCartById(id,userInfo.getId());
        List<ProductInfo> productInfoList = productService.getCartByuserId(userInfo.getId());
        List<ShoppingCartInfo> shoppingCartInfoList = productService.getCart2ByuserId(userInfo.getId());
        req.setAttribute("shoppingCartInfoList",shoppingCartInfoList);
        req.setAttribute("productInfoList",productInfoList);
        req.getRequestDispatcher("/buy.jsp").forward(req,resp);
    }

    /**
     *  删除物品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void clearCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer userId = Integer.parseInt(req.getParameter("userId"));
        productService.clearCart(id);
        List<ProductInfo> productInfoList = productService.getCartByuserId(userId);
        List<ShoppingCartInfo> shoppingCartInfoList = productService.getCart2ByuserId(userId);
        req.setAttribute("shoppingCartInfoList",shoppingCartInfoList);
        req.setAttribute("productInfoList",productInfoList);
        req.getRequestDispatcher("/buy.jsp").forward(req,resp);
    }


}
