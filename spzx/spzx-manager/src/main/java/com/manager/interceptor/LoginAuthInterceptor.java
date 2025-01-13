package com.manager.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.model.entity.system.SysUser;
import com.model.vo.common.Result;
import com.model.vo.common.ResultCodeEnum;
import com.utils.AuthContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/5
 **/
@Component
public class LoginAuthInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 拦截器==>在请求之前处理
     * @param request
     * @param response
     * @param handler
     * @return true(放行) false(拦截)
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //knife4j的预检请求
        val servletPath = request.getServletPath();
        System.out.println(servletPath);


        String method = request.getMethod();
        //如果预检请求，直接返回true
        if(method.equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        //获取token
        String token = request.getHeader("token");
        //判断token是否为空
        if(StrUtil.isEmpty(token)) {
            responseNoLoginInfo(response);
            return false;
        }
        //从redis中获取用户信息
        String redisUser = redisTemplate.opsForValue().get("user:login:" + token);

        if(StrUtil.isEmpty(redisUser)) {
            responseNoLoginInfo(response);
            return false;
        }

        SysUser sysUser = JSON.parseObject(redisUser, SysUser.class);
        //存储到线程变量中
        AuthContextUtil.set(sysUser);
        //重新设置redis中的过期时间
        redisTemplate.expire("user:login:" + token,30, TimeUnit.MINUTES);
        return true;
    }

    private void responseNoLoginInfo(HttpServletResponse response)  {
        //构建相应内容
        Result result = Result.build(null, ResultCodeEnum.LOGIN_AUTH);
        //处理中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //返回响应
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            //响应
            printWriter.print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }
    }
    /**
     * 拦截器==>在响应之前处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //清除线程变量
        AuthContextUtil.remove();
    }

}
