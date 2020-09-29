package com.zretc.dao;

import com.zretc.entity.Product;

import java.util.List;

public interface ProductDao {
    //根据商品名称模糊查询
    List<Product> selectLikeName(String name);
}
