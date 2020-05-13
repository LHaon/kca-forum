package com.mezjh.kcaforum.common.utils.exception;

/**
 * @author zjh
 * @date 2020/5/13
 */
public class KcaException extends RuntimeException{
    private static final long serialVersionUID = -7443213283905815106L;
    private int code;

    public KcaException() {
    }

    /**
     * MtonsException
     * @param code 错误代码
     */
    public KcaException(int code) {
        super("code=" + code);
        this.code = code;
    }

    /**
     * MtonsException
     * @param message 错误消息
     */
    public KcaException(String message) {
        super(message);
    }

    /**
     * MtonsException
     * @param cause 捕获的异常
     */
    public KcaException(Throwable cause) {
        super(cause);
    }

    /**
     * MtonsException
     * @param message 错误消息
     * @param cause 捕获的异常
     */
    public KcaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * MtonsException
     * @param code 错误代码
     * @param message 错误消息
     */
    public KcaException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
