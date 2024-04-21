package com.entity;

/**
 * @Description: 商品信息
 */
public class ProductInfo {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品卖家
     */
    private String seller;

    /**
     * 商品类别
     */
    private String category;

    /**
     * 商品价格
     */
    private double price;

    /**
     * 商品现价
     */
    private double nowPrice;

    /**
     * 商品折扣
     */
    private double discount;

    /**
     * 运费
     */
    private double shippingCost;

    /**
     * 剩余时间
     */
    private String remainTime;

    /**
     * 本期销量
     */
    private Integer soldNumber;

    /**
     * 总销量
     */
    private Integer allSoldNumber;

    /**
     * 商品状态
     */
    private String state;

    /**
     * 库存
     */
    private String nowNumber;

    /**
     * 产地
     */
    private String origin;

    /**
     * 浏览量
     */
    private int views;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(double nowPrice) {
        this.nowPrice = nowPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(String remainTime) {
        this.remainTime = remainTime;
    }

    public Integer getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Integer soldNumber) {
        this.soldNumber = soldNumber;
    }

    public Integer getAllSoldNumber() {
        return allSoldNumber;
    }

    public void setAllSoldNumber(Integer allSoldNumber) {
        this.allSoldNumber = allSoldNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNowNumber() {
        return nowNumber;
    }

    public void setNowNumber(String nowNumber) {
        this.nowNumber = nowNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
