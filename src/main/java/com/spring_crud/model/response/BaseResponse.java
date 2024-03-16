package com.spring_crud.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
// import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2380915129010365996L;

    private int status;
    private boolean success;
    private String message;

    @JsonIgnoreProperties({ "pageable", "sort" })
    private transient T data;

    public static BaseResponse<String> info(String message) {
        return BaseResponse.<String>builder()
                .success(true)
                .status(200)
                // .message(StringUtils.isNotBlank(message) ? message : "")
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> ok(T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .status(200)
                .message("OK")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> created(T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .status(201)
                .message("Created")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> ok(String message, T data) {
        return BaseResponse.<T>builder()
                .success(true)
                .status(200)
                // .message(StringUtils.isNotBlank(message) ? message : "")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> error(String message) {
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                // .message(StringUtils.isNotBlank(message) ? message : "")
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> error(String message, T data) {
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                // .message(StringUtils.isNotBlank(message) ? message : "")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> error(Throwable throwable) {
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                .message(throwable.getMessage())
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> internalError() {
        return BaseResponse.<T>builder()
                .status(500)
                .success(false)
                .message("System Error")
                .data(null)
                .build();
    }

    public static <T> BaseResponse<T> unauthorized(String message) {
        return BaseResponse.<T>builder()
                .status(401)
                .success(false)
                // .message(StringUtils.isNotBlank(message) ? message : "Unauthorized")
                .build();
    }
}
