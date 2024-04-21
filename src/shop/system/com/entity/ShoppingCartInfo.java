package com.entity;

/**
 * 购物车
 */
public class ShoppingCartInfo {

    /**
     * 购物车id
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer productId;

    /**
     * 用户id
     */
    private  Integer userId;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 数量
     */
    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
