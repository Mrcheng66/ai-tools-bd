package com.ching.aitools.interceptor;

import com.alibaba.fastjson.JSON;
import com.ching.aitools.model.domain.User;
import com.ching.aitools.utils.AuthContextUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginAuthInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是预检请求直接放行
        String method = request.getMethod();
        if ("OPTIONS".equals(method)) {
            return true;
        }

        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.setStatus(501);
            return false;
        }

        // 判断token是否有效
        String userId = redisTemplate.opsForValue().get(token);
        if (userId == null) {
            response.setStatus(501);
            return false;
        }

        // 查询到用户信息，并将用户信息存储到ThreadLocal中
        User user = JSON.parseObject(userId, User.class);
        if (user != null) {
            AuthContextUtil.setUser(user);
        }
        // 在这里也可以重制redis过期时间
//        redisTemplate.expire(token, 24, java.util.concurrent.TimeUnit.HOURS);
        return true;
    }
}
