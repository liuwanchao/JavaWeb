package com.zretc.service;

import com.zretc.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectLikeName(String name);
}
