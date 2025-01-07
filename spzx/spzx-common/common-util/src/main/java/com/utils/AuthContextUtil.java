package com.utils;

import com.model.entity.system.SysUser;

/**
 * @author 帕斯卡的芦苇
 * @date 2025/1/5
 **/
public class AuthContextUtil {
    // 线程本地变量
    private static final ThreadLocal<SysUser> THREAD_LOCAL = new ThreadLocal<>();
    public static void set(SysUser sysUser) {
        THREAD_LOCAL.set(sysUser);
    }
    public static SysUser get() {
        return THREAD_LOCAL.get();
    }
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
