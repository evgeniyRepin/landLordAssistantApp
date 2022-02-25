package com.landlordassistant.application.dto;

public class ResponseDto<T> {
    private T data;
    private StatusType statusType;
    private String message;

    public ResponseDto() {
        this.data = null;
        this.statusType = null;
        this.message = null;
    }

    public ResponseDto(T data, StatusType statusType, String message) {
        this.data = data;
        this.statusType = statusType;
        this.message = message;
    }

    public static <T> ResponseDto<T> success(T dataClass) {
        return new ResponseDto<>(
                dataClass,
                StatusType.OK,
                null
        );
    }

    public static <T> ResponseDto<T> success() {
        return new ResponseDto<>(
                null,
                StatusType.OK,
                null
        );
    }

    public static <T> ResponseDto<T> error(String message) {
        return new ResponseDto<>(
                null,
                StatusType.ERROR,
                message
        );
    }

    public T getData() {
        return data;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
