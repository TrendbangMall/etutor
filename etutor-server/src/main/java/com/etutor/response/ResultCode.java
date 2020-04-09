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

    public static final ResultCode SUCCESS = new ResultCode(0, "Success");

    public static final ResultCode FAIL = new ResultCode(1, "系统服务错误");

    public static final ResultCode INVALID_PARAM = new ResultCode(2, "未知的非法参数");

    public static final ResultCode INVALID_REQUEST = new ResultCode(3, "请求缺少某个必需参数，包含一个不支持的参数或参数值，或者格式不正确。");

    public static final ResultCode INVALID_CLIENT = new ResultCode(4, "请求的 client_id 或 client_secret 参数无效。");

    public static final ResultCode EXPIRED_TIME = new ResultCode(5, "请求的 timestamp 已过期。");

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
