package com.mudongheng.ielp.security.filter;

import com.mudongheng.ielp.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 幕冬
 * @since 2021年10月27日
 */
@Slf4j
public class TokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("拦截请求：" + request.getRequestURL());
        // 登录注册请求放行
        if (request.getRequestURI().matches("/api/login") || request.getRequestURI().matches("/api/register")) {
            log.info("放行");
            filterChain.doFilter(request, response);
        } else {
            // 其他请求验证token
            String token = request.getHeader("Authorization");

            if (token == null) {
                log.error("token不存在，不允放行");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "token不存在，不允放行");
                return;
            }

            Integer userId = JWTUtil.getUserId(token);
            if (userId != null) {
                request.setAttribute("userId", userId);
                filterChain.doFilter(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未知token，不允放行");
                log.error("未知token，不允放行");
            }
        }
    }
}
