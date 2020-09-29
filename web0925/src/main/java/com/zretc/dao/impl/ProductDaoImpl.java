package com.zretc.dao.impl;

import com.zretc.dao.ProductDao;
import com.zretc.entity.Product;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    /**
     * 查询总记录数
     * @return
     */
    private int empCount(){
        String sql="SELECT count(1) from easybuy_product";
        ResultSet rs=DBUtil.exQuery(sql);
        int n= 0;
        try {
            if (rs.next()){
                n=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return n;
    }

    @Override
    public List<Product> selectLikeName(String name) {
        String sql="select * from product where name like ?";
        ResultSet rs= DBUtil.exQuery(sql,"%"+name+"%");
        List<Product> list=new ArrayList<>();
        try {
            while (rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql="insert into product values(0,?,?,?)";
        int n= DBUtil.exUpdate(sql,product.getName(),product.getPrice(),product.getImage());
        return n>0;
    }
}
