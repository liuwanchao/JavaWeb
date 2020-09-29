package com.zretc.dao;

import com.zretc.entity.Product;
import com.zretc.util.Page;

import java.util.List;

public interface ProductDao {
    //根据商品名称模糊查询
    List<Product> selectLikeName(String name);
    //添加商品
    boolean addProduct(Product product);
}
