package com.zretc.servlet;

import com.google.gson.Gson;
import com.zretc.entity.Product;
import com.zretc.service.ProductService;
import com.zretc.service.impl.ProductServiceImpl;
import com.zretc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProductServlet",value = "/product")
@MultipartConfig
public class ProductServlet extends HttpServlet {
    ProductService ps = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg=req.getParameter("msg");
        if ("add".equals(msg)){
            add(req,resp);
        }else if("select".equals(msg)){
            select(req,resp);
        }
    }

    /**
     * 根据商品名称模糊查询商品
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void select(HttpServletRequest req, HttpServletResponse resp)  throws IOException, ServletException {
        String name=req.getParameter("name");
        if (name==null){
            name="";
        }
        List<Product> list=ps.selectLikeName(name);
        req.setAttribute("list",list);
        req.getRequestDispatcher("productList.jsp").forward(req,resp);
    }

    /**
     * 文件上传
     * 添加商品
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name=req.getParameter("name");
        Double price= Double.valueOf(req.getParameter("price"));
        Part part=req.getPart("img");
        String oldName=part.getSubmittedFileName();
        //拼接文件新名称
        String newName="/"+ UUID.randomUUID().toString().replaceAll("-","").toLowerCase()+
                oldName.substring(oldName.lastIndexOf("."));
        String path=getServletContext().getRealPath("/upload");
        File file=new File(path);
        if (!file.exists()){
            file.mkdir();
        }
        part.write(path+newName);
        boolean flag=ps.addProduct(new Product(1,name,price,"/upload"+newName));
        if (flag){
            resp.sendRedirect(req.getContextPath()+"/product?msg=select");
        }else {
            req.setAttribute("msg","添加商品失败");
            req.getRequestDispatcher("addProduct.jsp").forward(req,resp);
        }
    }


}
