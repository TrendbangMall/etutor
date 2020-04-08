package com.winter.etutor.bean;


import java.io.Serializable;

/**
 * 前端页面基础输出结果
 * <p/>
 * Created by liaoke.lk on 14-8-8.
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -4066036780988255759L;

    public static final String DEFAULT_FAILURE_MSG = "未知异常";

    /**
     * 结果状态
     */
    private boolean success;
    /**
     * 服务器主机信息
     */
    private String host;

    /**
     * csrf的token
     */
    private String _csrf;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String get_csrf() {
        return _csrf;
    }

    public void setCsrf(String csrf) {
        this._csrf = csrf;
    }

    /**
     * 成功结果
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> createSuccess(T t) {
        return new BaseSuccessResult(t);
    }

    /**
     * 失败结果
     *
     * @param message
     * @return
     */
    public static <T> BaseResult<T> createFailure(String message) {
        return new BaseFailureResult(message);
    }

    public static <T> BaseResult<T> createFailure() {
        return createFailure(DEFAULT_FAILURE_MSG);
    }


    public static <T> BaseResult<T> createFailure(T t) {
        return new BaseFailureResult(t);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class BaseSuccessResult<T> extends BaseResult {
        private static final long serialVersionUID = -7862089847755693221L;
        private T root;

        public BaseSuccessResult(T root) {
            this.setSuccess(true);
            this.root = root;
        }

        public T getRoot() {
            return root;
        }
    }

    public static class BaseFailureResult<T> extends BaseResult {
        private static final long serialVersionUID = -6076327534847740296L;
        private String message;
        private T root;

        public BaseFailureResult(String message) {
            this.setSuccess(false);
            this.message = message;
        }

        public BaseFailureResult(T root) {
            this.setSuccess(false);
            this.root = root;
        }

        public T getRoot() {
            return root;
        }

        public String getMessage() {
            return message;
        }
    }
}
