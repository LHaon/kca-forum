package com.mezjh.kcaforum.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zjh
 * @date 2019/11/11
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiResult<T> implements Serializable {


    public static ApiResult success() {
        return new ApiResult(true, "200", "success");
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, "200", "success", data);
    }

    public static ApiResult fail(String message) {
        return new ApiResult(false, "500", message);
    }

    public static ApiResult error(String message) {
        return new ApiResult(false, "501", message);
    }

    public static ApiResult paramError(String message) {
        return new ApiResult(true, "400", message);
    }

    public ApiResult() {
    }

    public ApiResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResult(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ApiResult(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static final long serialVersionUID = -2402122704294916086L;


    @ApiModelProperty("是否成功")
    private Boolean success = Boolean.TRUE;
    @ApiModelProperty("返回码:200 正常, 500服务器错")
    private String code;
    @ApiModelProperty("是否成功")
    private String message;
    @ApiModelProperty("是否成功")
    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
        "success=" + success +
        ", code='" + code + '\'' +
        ", message='" + message + '\'' +
        ", data=" + (null == data ? "null" : data.toString()) +
        '}';
    }
}
