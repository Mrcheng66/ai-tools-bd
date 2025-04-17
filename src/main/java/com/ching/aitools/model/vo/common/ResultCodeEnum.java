package com.ching.aitools.model.vo.common;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(500, "失败"),
    UNAUTHORIZED(401, "未认证"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "网关错误"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    // 用户相关
    USER_NOT_FOUND(10001, "用户不存在"),
    USER_ALREADY_EXIST(10002, "用户已存在"),
    USER_LOGIN_FAIL(10003, "用户名或密码错误"),
    USER_NOT_LOGIN(10004, "用户未登录"),
    USER_LOGIN_EXPIRED(10005, "用户登录过期"),
    USER_LOGIN_LOCKED(10006, "用户登录被锁定"),
    USER_LOGIN_DISABLED(10007, "用户登录被禁用"),
    USER_LOGIN_CREDENTIALS_EXPIRED(10008, "用户登录凭证过期"),
    USER_NOT_SAME_PASSWORD(10009, "用户注册两次密码不一致"),
    USER_NOT_EMPTY(10010, "用户信息不能为空"),

    GATEWAY_TIMEOUT(504, "网关超时");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
