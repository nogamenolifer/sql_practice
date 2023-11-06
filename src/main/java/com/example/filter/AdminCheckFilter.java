package com.example.filter;


import com.alibaba.fastjson.JSON;
import com.example.controller.Code;
import com.example.util.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "adminCheckFilter", urlPatterns = "/*")
//        ,initParams = {@WebInitParam(name = "noFilter",value = "/css/**")})
public class AdminCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //得到req,res,url
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //URI不是URL
        String requsetURL = request.getRequestURI();
        log.info("拦截到请求：{}", requsetURL);

        //不需要处理的请求
        String[] urls = new String[] {
                "/",
                "/css/**",
                "/pages/**",
                "/js/**",
                "/plugins/**",
                "/admin/login"
        };

        //查看是否要检查
        boolean check = check(urls, requsetURL);

        if(check) {
            log.info("本次请求{}不需要处理", requsetURL);
            //处理完毕，直接放行
            filterChain.doFilter(request, response);
        } else {
            //确认登陆状态
            if (request.getSession().getAttribute("admin") != null) {
                log.info("管理员已登陆,id为:{}", request.getSession().getAttribute("admin"));
                //确认完毕，放行
                filterChain.doFilter(request, response);
            } else {
                log.info("管理员未登陆!");
                //将数据情况给前端
                response.getWriter().write(JSON.toJSONString(new Res("管理员未登陆", Code.ADMIN_VISIT_ERR)));
            }
        }



    }

//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }

    /**
     * @param urls
     * @param requestURL
     * @return boolean
     */
    public boolean check(String[] urls,  String requestURL) {
        for (String url : urls) {
            //确认路径匹配
            boolean match = PATH_MATCHER.match(url, requestURL);
            if(match)
            {
                return true;
            }
        }
        return false;
    }
}
