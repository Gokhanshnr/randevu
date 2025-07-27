package com.magch.randevu.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class GeneralException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -2553311678120681132L;

    private String errorCode;
    private String message;
    private boolean success = false;

    public GeneralException() {
        super();
    }

    public GeneralException(String message) {
        super(message);
        this.message = message;
    }

    public GeneralException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public GeneralException(String errorCode, String message, boolean success) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
        this.success = success;
    }

}
