package com.umld.tasks.model;

public class ModelError extends Throwable {
    private String message;
    private String localizedMessage;
    private int code;
    private ErrorCodes errorCode;

    public ModelError(String message, String localizedMessage, ErrorCodes errorCode) {
        this.message = message;
        this.localizedMessage = localizedMessage;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        if(localizedMessage == null)
            return message;
        return localizedMessage;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public enum ErrorCodes {
        UNKNOWN,
        INTERNAL_SERVER_ERROR,
        NETWORK_ERROR,
        BARCODE_ALREADY_EXISTS,
        INSUFFICIENT_QUANTITY,
        BAD_CREDENTIALS,
        ARTICLE_NOT_FOUND,
        ORDER_LOCKED,
        ORDER_LOCKED_FOR_ANOTHER_USER,
        ORDER_NOT_FOUND,
        ORDER_ITEM_NOT_FOUND,
        WAREHOUSE_NOT_FOUND,
        QUANTITY_IS_NOT_DEFINED,
        SQL_ERROR,
        EXCEEDED_QUANTITY
    }
}
