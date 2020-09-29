package com.zretc.controller;

import com.google.gson.Gson;
import com.zretc.entity.Product;
import com.zretc.service.ProductService;
import com.zretc.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "proServlet",urlPatterns = "/pro")
public class ProductServlet extends HttpServlet {
    ProductService ps = new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("pName");
        if (name==null){
            name="";
        }
        List<Product> list = ps.selectLikeName(name);
        //格式转化
        Gson gson=new Gson();
        String products=gson.toJson(list);
        //发送数据
        PrintWriter out = resp.getWriter();
        out.write(products);
        out.flush();

    }



}
