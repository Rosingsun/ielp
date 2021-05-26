package com.company.ielp.app.interceptor;

import com.company.ielp.app.annotation.PassToken;
import com.company.ielp.app.mapper.UserMapper;
import com.company.ielp.app.model.dto.UserDTO;
import com.company.ielp.app.service.UserService;
import com.company.ielp.app.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 * @author 幕冬
 */
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    final String INTERCEPTOR_SUCCESS = "方法已被拦截。";

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object)  {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有passToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        } else {    // 执行拦截
            log.info("Jwt拦截器执行拦截，尝试拦截：{}", method);
            // 执行认证
            if (token == null) {
                // 没有token，需要登陆
                log.info("前端传入缺失token，需要登陆账户。");
                log.info(INTERCEPTOR_SUCCESS);
                return false;
            }

            // 获取 token 中的 user Name
            Integer userId = JwtUtil.getAudience(token);

            if (userId == null) {
                log.info("token异常，请检查token或者重新登陆！");
                log.info(INTERCEPTOR_SUCCESS);
                return false;
            }

            // 获取id，检查是否存在
            UserDTO userDTO = userService.getUserById(userId);

            // 若数据库中没有对象
            if (userDTO == null) {
                log.info("token信息错误，数据库中不存在该用户，请重新登陆或注册。");
                log.info(INTERCEPTOR_SUCCESS);
                return false;
            }
        }
        log.info("token信息正确，放行！");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) {
    }
}