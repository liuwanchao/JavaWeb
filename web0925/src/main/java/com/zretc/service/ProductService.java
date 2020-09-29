package com.zretc.service;

import com.zretc.entity.Product;

import java.util.List;

public interface ProductService {
    //根据商品名称模糊查询
    List<Product> selectLikeName(String name);
    //添加商品
    boolean addProduct(Product product);
}