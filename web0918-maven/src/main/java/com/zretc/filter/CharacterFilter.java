package com.zretc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "CcharacterFilter",urlPatterns = "/*",initParams ={
        @WebInitParam(name = "character",value = "utf-8")
} )
public class CharacterFilter implements Filter {
    private String character;

    /**
     * 过滤器初始化方法
     * @param filterConfig
     * @throws
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //config获取初始化参数
        character=filterConfig.getInitParameter("character");
    }

    /**
     * 过滤器过滤方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(character);
        servletResponse.setCharacterEncoding(character);

        getAddress((HttpServletRequest) servletRequest);

        filterChain.doFilter(servletRequest,servletResponse);
    }
    public boolean getAddress(HttpServletRequest request){
        //获取项目路径
        String path=request.getContextPath();
        String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        String referer=request.getHeader("referer");

        System.out.println(url);
        System.out.println(referer);
        return referer!=null&&referer.startsWith(url);
    }
    /**
     * 过滤器销毁方法
     */
    @Override
    public void destroy() {
    }
}
