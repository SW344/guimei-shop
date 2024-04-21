package com.dao.Mapper;

import com.entity.ShoppingInfo;
import com.entity.ProductInfo;
import com.entity.ShoppingCartInfo;
import com.dao.BaseDao;

import java.util.List;


public class ProductMapper extends BaseDao implements com.dao.ProductMapper {
    @Override
    public List<ProductInfo> selectAll() {
        String sql = "select * from product";
        return queryByList(ProductInfo.class, sql);
    }

    @Override
    public ProductInfo selectById(int id) {
        try {
            return queryByOne(ProductInfo.class, "select * from product where id = ?", id);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ProductInfo> selectByCategory(String category) {
        try {
            return queryByList(ProductInfo.class, "select * from product where category = ?", category);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void addViewsById(Integer id) {
        update("update product set views = views + 1 where id = ?", id);
    }

    @Override
    public void addShoppingCartById(Integer id, Integer userId) {
        update("insert into shoppingcart (productId, userId, state, number) values (?, ?, ?, ?)", id, userId, 1, 1);
    }

    @Override
    public List<ProductInfo> selectCartByUserId(Integer id) {
        try {
            return queryByList(ProductInfo.class, "select * from product where id in (select productId from shoppingcart where userId = ? and state = ?)", id, 1);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean selectByPIdAndUId(Integer id, Integer userid) {
        if (queryBySingLeValue("select * from shoppingcart where productId = ? and userId = ?", id, userid) != null){
            return true;
        }
        return false;
    }

    @Override
    public void addNumber(Integer id, Integer userid) {
        update("update shoppingcart set number = number + 1 where productId = ? and userId = ?", id, userid);
        update("update shoppingcart set state = ? where productId = ? and userId = ?", 1, id, userid);
    }

    @Override
    public List<ShoppingCartInfo> selectCart2ByUserId(Integer id) {
        try {
            return queryByList(ShoppingCartInfo.class, "select * from shoppingcart where userId = ? and state = ?", id, 1);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public void clearCart(Integer id) {
        update("update shoppingcart set state = ? where id = ?", 0, id);
        update("update shoppingcart set number = ? where id = ?", 0, id);
    }

    @Override
    public void addSoldNumber(Integer number, Integer id) {
        update("update product set soldNumber = soldNumber + ? where id = ?", number, id);
    }

    @Override
    public void addAllSoldNumber(Integer number, Integer id) {
        update("update product set allSoldNumber = allSoldNumber + ? where id = ?", number, id);
    }

    @Override
    public void minusNowNumber(Integer number, Integer id) {
        update("update product set nowNumber = nowNumber - ? where id = ?", number, id);
    }

    @Override
    public void insertBuyInfo(ShoppingCartInfo shoppingCartInfo, ShoppingInfo buyInfo) {
        update("insert into buy (userId, productId, consignee, address, phone ) values (?, ?, ?, ?, ?)", buyInfo.getUserId(), buyInfo.getProductId(), buyInfo.getConsignee(), buyInfo.getAddress(), buyInfo.getPhone());
    }

    @Override
    public ProductInfo selectByKeyWord(String keyword) {
        if (queryBySingLeValue("select * from product where name like ?", "%" + keyword + "%") != null){
            return queryByOne(ProductInfo.class, "select * from product where name like ?", "%" + keyword + "%");
        }
        return null;
    }

}
