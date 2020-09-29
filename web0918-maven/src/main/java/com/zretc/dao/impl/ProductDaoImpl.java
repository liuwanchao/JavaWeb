package com.zretc.dao.impl;

import com.zretc.dao.ProductDao;
import com.zretc.entity.Product;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> selectLikeName(String name) {
        String sql="select * from easybuy_product where name like ?";
        ResultSet rs= DBUtil.exQuery(sql,"%"+name+"%");
        List<Product> list=new ArrayList<>();
        try {
            while (rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                product.setFileName(rs.getString("fileName"));
                product.setIsDelete(rs.getInt("isDelete"));
                product.setBrand_id(rs.getInt("brand_id"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }
}
