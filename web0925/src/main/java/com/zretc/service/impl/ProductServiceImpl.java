package com.zretc.service.impl;

import com.zretc.dao.ProductDao;
import com.zretc.dao.impl.ProductDaoImpl;
import com.zretc.entity.Product;
import com.zretc.service.ProductService;
import com.zretc.util.Page;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao pd=new ProductDaoImpl();
    @Override
    public List<Product> selectLikeName(String name){
        return pd.selectLikeName(name);
    }

    @Override
    public boolean addProduct(Product product) {
        return pd.addProduct(product);
    }
}
