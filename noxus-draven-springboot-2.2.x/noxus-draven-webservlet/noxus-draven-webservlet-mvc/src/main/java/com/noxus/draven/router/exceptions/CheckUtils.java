package com.noxus.draven.router.exceptions;

import lombok.Data;

/**
 * @author draven
 */
@Data
public class CheckUtils extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String fieldName;

    private String fieldValue;

    public CheckUtils() {
        super();
    }

    public CheckUtils(String message) {
        super(message);
    }

    public CheckUtils(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckUtils(Throwable cause) {
        super(cause);
    }

    protected CheckUtils(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CheckUtils(String message, String fieldName, String fieldValue) {
        super(message);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
