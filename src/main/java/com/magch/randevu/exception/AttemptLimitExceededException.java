package com.magch.randevu.exception;

public class AttemptLimitExceededException extends RuntimeException {
    public AttemptLimitExceededException() {
        super();
    }

    public AttemptLimitExceededException(String message) {
        super(message);
    }

    public AttemptLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public AttemptLimitExceededException(Throwable cause) {
        super(cause);
    }
}
