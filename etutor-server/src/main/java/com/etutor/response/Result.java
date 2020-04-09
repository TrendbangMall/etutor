package com.etutor.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author huangyuan
 * @date 2019/12/23
 */
@Data
@ToString
public class Result<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public static final Result<String> FAIL;
    public static final Result<String> INVALID_PARAM;

    public static final int FAIL_CODE = 500;

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean success() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public boolean failed() {
        return this.code != ResultCode.FAIL.getCode();
    }

    public boolean ok() {
        return this.success() && this.data != null;
    }

    private static <T> Result<T> wrap(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> success(T data) {
        return wrap(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <E> Result<E> failed(int code, String msg) {
        return wrap(code, msg, null);
    }

    public static <E> Result<E> failed(String msg) {
        return failed(ResultCode.FAIL.getCode(), msg);
    }

    public static <E> Result<E> failed(ResultCode resultCode) {
        return failed(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> Result<T> failed(ResultCode resultCode, T data) {
        return wrap(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static <T> Result<T> failed(int code, String msg, T data) {
        return wrap(code, msg, data);
    }


    static {
        FAIL = failed(ResultCode.FAIL);
        INVALID_PARAM = failed(ResultCode.INVALID_PARAM);
    }
}
