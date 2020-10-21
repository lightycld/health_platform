package com.health.common.vo;


import lombok.Data;

/**
 * Create By yangwei
 * Create at 2019/08/02 13:54
 * Description:
 */

@Data
public class ResponseBean<T> {

    ResponseCode code;

    String message;

    T data;

    public ResponseBean() {
    }

    private ResponseBean(ResponseCode code) {
        this.code = code;
        this.message = code.getMessage();
    }

    private ResponseBean(ResponseCode code, T data) {
        this.code = code;
        this.message = code.getMessage();
        this.data = data;
    }

    private ResponseBean(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseBean success(T data) {
        return new ResponseBean(ResponseCode.SUCCESS, data);
    }

    public static ResponseBean success() {
        return new ResponseBean(ResponseCode.SUCCESS);
    }

    public static ResponseBean error() {
        return new ResponseBean(ResponseCode.ERROR);
    }

    public static ResponseBean error(String message) {
        return new ResponseBean(ResponseCode.ERROR, message);
    }

    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS;
    }

}
