package com.zretc.test;

import com.zretc.service.ProductService;
import com.zretc.service.impl.ProductServiceImpl;
import org.junit.Test;

public class ProductTest {
    ProductService ps=new ProductServiceImpl();
    @Test
    public void se(){
        ps.selectLikeName("").forEach(System.out::println);
    }
}
