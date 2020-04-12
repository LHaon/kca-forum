package com.mezjh.kcaforum.common.utils.annotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断是否登录注解拦截器
 *
 * @author zjh
 * @date 2020/4/12
 */
@Slf4j
public class RequireLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean isExistAnnotation = handler.getClass().isAssignableFrom(HandlerMethod.class);
        if(isExistAnnotation) {
            RequireLogin requireLogin = ((HandlerMethod) handler).getMethodAnnotation(RequireLogin.class);
            if(requireLogin.isLogin()) {
                log.info("The user is logged in");
            }
        }
        return true;
    }

}
