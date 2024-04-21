package com.service;

import com.entity.ShoppingInfo;
import com.entity.ProductInfo;
import com.entity.ShoppingCartInfo;

import java.util.List;

public interface ProductService {

    /**
     * 根据分类查询商品
     * @param category
     * @return
     */
    List<ProductInfo> getProductByCategory(String category);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    ProductInfo getProductById(Integer id);

    /**
     * 商品加入购物车
     * @param id
     * @return
     */
    void addShoppingCartById(Integer id , Integer userId);

    /**
     * 根据用户id查询购物车
     * @param id
     * @return
     */
    List<ProductInfo> getCartByuserId(Integer id);

    /**
     * 根据用户id查询购物车
     * @param id
     * @return
     */
    List<ShoppingCartInfo> getCart2ByuserId(Integer id);

    /**
     * 从购物车删除物品
     * @param id
     */
    void clearCart(Integer id);

    /**
     * 购买商品
     * @param shoppingCartInfo
     * @param buyInfo
     */
    void buy(ShoppingCartInfo shoppingCartInfo, ShoppingInfo buyInfo);

    /**
     * 根据关键字模糊查询商品
     * @param keyword
     * @return
     */
    ProductInfo selectByKeyWord(String keyword);
}
