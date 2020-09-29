package com.zretc.util;

import java.util.List;

public class Page<T> {
    //当前页
    private int currentPage;
    //单页数据量
    private int pageSize;
    //总数据量
    private int totalData;
    //当前页数据
    private List<T> data;

    //总页数
    public int totalPageCount(){
        //总数/单页数据量   向上取整
        int totalPageCount=totalData/pageSize;
        if (totalData%pageSize==0)
            return totalPageCount;
        return totalPageCount+1;
    }
    //上一页
    public int upPage(){
        if (currentPage-1>0)
            return currentPage-1;
        return 1;
    }
    //下一页
    public int downPage(){
        if (currentPage+1>totalPageCount())
            return totalPageCount();
        return currentPage+1;
    }
    //SQL起始位置
    public int start(){
        return (currentPage-1)*pageSize;
    }

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
