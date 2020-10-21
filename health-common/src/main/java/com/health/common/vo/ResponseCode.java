package com.health.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Create By yangwei
 * Create at 2020/04/15 16:37
 * Description:
 */
public enum ResponseCode {

    SUCCESS(1, "SUCCESS"),

    ERROR(0, "ERROR");

    @JsonValue
    int code;

    String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @JsonCreator
    public static ResponseCode valueOfCode(int code) {
        return code == 1 ? SUCCESS : ERROR;
    }
}
