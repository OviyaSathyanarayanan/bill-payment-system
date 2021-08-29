package com.project.exceptions;

public class ProjectBusinessException extends Exception {

    public ProjectBusinessException() {
    }

    public ProjectBusinessException(String message) {
        super(message);
    }

    public ProjectBusinessException(Throwable cause) {
        super(cause);
    }

    public ProjectBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectBusinessException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
