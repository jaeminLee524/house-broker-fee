package com.dev.houseutils.houseutils.exception;

public class HouseUtilsException extends RuntimeException {

    public HouseUtilsException(ErrorCode errorCode) {
        super(errorCode.getDescription());
    }
}
