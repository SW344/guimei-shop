package com.dao;

import com.entity.ShoppingInfo;
import com.entity.ProductInfo;
import com.entity.ShoppingCartInfo;

import java.util.List;

public interface ProductMapper {

    /**
     * 查询所有商品
     * @return
     */
    public List<ProductInfo> selectAll();

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    ProductInfo selectById(int id);

    /**
     * 根据分类查询商品
     * @param category
     * @return
     */
    List<ProductInfo> selectByCategory(String category);

    /**
     * 根据id增加浏览量
     * @param id
     */
    void addViewsById(Integer id);

    /**
     * 添加购物车
     * @param id
     * @param userId
     */
    void addShoppingCartById(Integer id , Integer userId);

    /**
     * 查询购物车
     * @param id
     * @return
     */
    List<ProductInfo> selectCartByUserId(Integer id);

    /**
     * 查询购物车
     * @param id
     * @return
     */
    boolean selectByPIdAndUId(Integer id, Integer userid);

    /**
     * 购物车物品加1
     * @param id
     * @param userid
     */
    void addNumber(Integer id, Integer userid);

    /**
     * 查询购物车
     * @param id
     * @return
     */
    List<ShoppingCartInfo> selectCart2ByUserId(Integer id);

    /**
     * 从购物车删除物品
     * @param id
     */
    void clearCart(Integer id);

    /**
     * 添加本期购买量
     * @param number
     * @param id
     */
    void addSoldNumber(Integer number, Integer id);

    /**
     * 添加总购买量
     * @param number
     * @param id
     */
    void addAllSoldNumber(Integer number, Integer id);

    /**
     * 减少库存数量
     * @param number
     * @param id
     */
    void minusNowNumber(Integer number, Integer id);

    /**
     * 添加购买记录
     * @param shoppingCartInfo
     * @param buyInfo
     */
    void insertBuyInfo(ShoppingCartInfo shoppingCartInfo, ShoppingInfo buyInfo);

    /**
     * 根据关键字模糊查询商品
     * @param keyword
     * @return
     */
    ProductInfo selectByKeyWord(String keyword);
}
