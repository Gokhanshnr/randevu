package com.magch.randevu.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class BaseResponse<T>  implements Serializable {

    @Serial
    private static final long serialVersionUID = -6535921409092675L;
    private boolean success;
    private String errorCode;
    private String errorMessage;
    private T result;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, String errorCode, String errorMessage, T result) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.result = result;
    }

    public BaseResponse(boolean success, String errorCode, String errorMessage) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseResponse(boolean success, T recordId) {
        this.success = success;
        this.result = recordId;
    }

    public BaseResponse(boolean success) {
        this.success = success;
    }

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(true);
    }

    public static <T> BaseResponse<T> ok(T result) {
        return new BaseResponse<T>(true,  result);
    }

    public static <T> BaseResponse<T> resultToResponse(T result) {
        boolean isSuccess = result != null;
        String message = isSuccess ? null : "Result is null";
        return new BaseResponse<>(isSuccess, null, message, result);
    }

    public static <T> BaseResponse<T> ok(String  errorCode, String message) {
        return new BaseResponse<>(true,errorCode , message);
    }

    public static <T> BaseResponse<T> fault( String errorCode, String message, T result) {
        return new BaseResponse<>(false,errorCode, message, result);
    }

    public static <T> BaseResponse<T> fault(String errorCode, String message) {
        return new BaseResponse<>(false, errorCode, message);
    }

    public static <T> BaseResponse<T> fault(String message) {
        return new BaseResponse<>(false, null, message);
    }


}
