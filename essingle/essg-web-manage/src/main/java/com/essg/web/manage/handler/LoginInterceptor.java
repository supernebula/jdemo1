package com.essg.web.manage.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * HandlerInterceptorAdapter 抽象类 是HandlerInterceptor的 抽象实现
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    private String loginUriPath = "/login";

    private List<String> excludePatterns = new ArrayList<String>(Arrays.asList("/home/error", "/error", loginUriPath));


    /**
     * 请求之前调用，链式调用。如果返回false，后续的Interceptor 和 Controller都不会执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        if(isExclude(uri))
            return true;



        //获取session
        HttpSession session = request.getSession(true);
        //判断用户ID是否存在，不存在就跳转到登录页面
        if(session.getAttribute("userId") == null){
            log.info("跳转到login页面！");
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        session.setAttribute("userId", session.getAttribute("userId"));
        return true;
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }

    private boolean isExclude(String uri)
    {
        for (String pattern : excludePatterns){
            if(Pattern.matches(pattern, uri))
                return true;
        }
        return false;
    }


}
