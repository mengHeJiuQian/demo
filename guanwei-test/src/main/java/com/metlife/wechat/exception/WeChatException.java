package com.metlife.wechat.exception;

import com.metlife.wechat.enums.BaseEnum;

/**
 * 功能描述：
 * 接口统一异常基类.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.common.exception.WeChatException.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-10-17 15:35:31
 */
public class WeChatException extends RuntimeException {
    private static final long serialVersionUID = 4259743923753497921L;

    /**
     * code状态码.
     */
    private Integer code;

    /**
     * 错误信息.
     */
    private String msg;

    /**
     * WeChatException.
     */
    public WeChatException() {
        super();
    }

    /**
     * WeChatException.
     */
    public WeChatException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * WeChatException.
     */
    public WeChatException(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * WeChatException.
     */
    public WeChatException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
    }

    /**
     * WeChatException.
     * @param baseEnum 枚举基类
     */
    public WeChatException(BaseEnum baseEnum) {
        super(baseEnum.getDesc());
        this.code = Integer.valueOf(baseEnum.getCode().toString());
        this.msg = baseEnum.getDesc();
    }

    /**
     * getCode.
     */
    public Integer getCode() {
        return code;
    }

    /**
     * setCode.
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * getMsg.
     */
    public String getMsg() {
        return msg;
    }

    /**
     * setMsg.
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}