package com.service.impl;

import com.dao.Mapper.ProductMapper;
import com.dao.Mapper.UserMapper;
import com.entity.ShoppingInfo;
import com.entity.ProductInfo;
import com.entity.ShoppingCartInfo;
import com.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    com.dao.ProductMapper productMapper = new ProductMapper();
    com.dao.UserMapper userMapper = new UserMapper();

    @Override
    public List<ProductInfo> getProductByCategory(String category) {
        List<ProductInfo> productInfos = productMapper.selectByCategory(category);
        return productInfos;
    }

    @Override
    public ProductInfo getProductById(Integer id) {
        if (id != null) {
            productMapper.addViewsById(id);
            ProductInfo productInfo = productMapper.selectById(id);
            return productInfo;
        }
        return null;
    }

    @Override
    public void addShoppingCartById(Integer id, Integer userid) {
        if (productMapper.selectByPIdAndUId(id, userid)){
            productMapper.addNumber(id, userid);
        }else {
            productMapper.addShoppingCartById(id, userid);
        }
    }

    @Override
    public List<ProductInfo> getCartByuserId(Integer id) {
        if (id != null) {
            List<ProductInfo> productInfos = productMapper.selectCartByUserId(id);
            return productInfos;
        }
        return null;
    }

    @Override
    public List<ShoppingCartInfo> getCart2ByuserId(Integer id) {
        if (id != null) {
            List<ShoppingCartInfo> shoppingCartInfos = productMapper.selectCart2ByUserId(id);
            return shoppingCartInfos;
        }
        return null;
    }

    @Override
    public void clearCart(Integer id) {
        productMapper.clearCart(id);
    }

    @Override
    public void buy(ShoppingCartInfo shoppingCartInfo, ShoppingInfo buyInfo) {
            ProductInfo productInfo = productMapper.selectById(shoppingCartInfo.getProductId());
            if (shoppingCartInfo.getNumber()<Integer.parseInt(productInfo.getNowNumber())){
                productMapper.addSoldNumber(shoppingCartInfo.getNumber(), shoppingCartInfo.getProductId());
                productMapper.addAllSoldNumber(shoppingCartInfo.getNumber(), shoppingCartInfo.getProductId());
                productMapper.minusNowNumber(shoppingCartInfo.getNumber(), shoppingCartInfo.getProductId());
                productMapper.clearCart(shoppingCartInfo.getId());
                productMapper.insertBuyInfo(shoppingCartInfo,buyInfo);
            }else {
                throw new RuntimeException("库存不足");
            }
        }

    @Override
    public ProductInfo selectByKeyWord(String keyword) {
        if (keyword != null) {
            ProductInfo productInfo = productMapper.selectByKeyWord(keyword);
            return productInfo;
        }
        return null;
    }

}
