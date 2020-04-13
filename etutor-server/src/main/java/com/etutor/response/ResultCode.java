package com.etutor.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huangyuan
 * @date 2019/12/23
 */
@Data
public class ResultCode implements Serializable {

    private int code;
    private String msg;

    // 请求检验的返回码
    public static final ResultCode SUCCESS = new ResultCode(0, "Success");

    public static final ResultCode FAIL = new ResultCode(1, "系统服务错误");

    public static final ResultCode INVALID_PARAM = new ResultCode(2, "未知的非法参数");

    public static final ResultCode INVALID_REQUEST = new ResultCode(3, "请求缺少某个必需参数，包含一个不支持的参数或参数值，或者格式不正确。");

    public static final ResultCode INVALID_CLIENT = new ResultCode(4, "请求的 client_id 或 client_secret 参数无效。");

    public static final ResultCode EXPIRED_TIME = new ResultCode(5, "请求的 timestamp 已过期。");

    // 登录过程的返回码

    public static final ResultCode LOGIN_SUCCESS = new ResultCode(10, "登录成功");

    public static final ResultCode LOGIN_FAIL = new ResultCode(31, "登录失败, 请检查用户名和密码");

    public static final ResultCode TOKEN_INVALID = new ResultCode(32, "token已过期, 请重新登录");

    public static final ResultCode TOKEN_NULL = new ResultCode(33, "token缺失");

    public static final ResultCode NO_POWER = new ResultCode(34, "没有后台管理权限");

    // 异常返回码

    public static final ResultCode ERROR_CODE = new ResultCode(20, "异常");

    public static final ResultCode SQL_ERROR = new ResultCode(21, "SQL异常");

    public static final ResultCode RUN_ERROR = new ResultCode(22, "运行异常");

    public static final ResultCode APP_ERROR = new ResultCode(23, "程序异常");

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
