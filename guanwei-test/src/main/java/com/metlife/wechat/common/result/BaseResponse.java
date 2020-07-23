package com.metlife.wechat.common.result;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述：
 * 接口层统一返回的数据封装接口.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.common.result.BaseResponse.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-10-19 15:20:24
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -3766531608939156283L;

    /**
     * 响应业务状态(200.成功，-1.失败,3.session过期).
     */
    private int code;

    /**
     * 响应消息.
     */
    private String message;

    /**
     * 响应中的数据.
     */
    private Object data;



    /**
     * success.
     */
    private boolean success;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message, Object data, boolean success) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    /**
     * success.
     */
    public static BaseResponse success() {
        return new BaseResponse(true);
    }

    /**
     * success.
     */
    public static BaseResponse success(Object data) {
        return new BaseResponse(true, data);
    }

    /**
     * success.
     */
    public static BaseResponse success(String message) {
        return BaseResponse.success().message(message);
    }

    /**
     * success.
     */
    public static BaseResponse success(Object data, String message) {
        return BaseResponse.success().data(data).message(message);
    }

    /**
     * failure.
     */
    public static BaseResponse failure() {
        return new BaseResponse(false);
    }

    /**
     * failure.
     */
    public static BaseResponse failure(String message) {
        return BaseResponse.failure().message(message);
    }

    /**
     * failure.
     */
    public static BaseResponse failure(Object data, String message) {
        return BaseResponse.failure().data(data).message(message);
    }


    /**
     * 功能描述:
     * 对外异常提示统一：业务异常（具体异常code）.
     *
     * @methodname: failure
     * @params: [errorEnum]
     * @returns: com.metlife.wechat.common.result.BaseResponse
     * @author: somnus
     * @date: 2019-10-19 15:22:10
     */
//    public static BaseResponse failure(ErrorEnum errorEnum) {
//        return BaseResponse.failure()
//                .message(String.format(ErrorEnum.BUSINESS_EXCEPTION_WITH_CODE.getDesc(), errorEnum.getCode()));
//    }
//
//
//    /**
//     * sessionFailure.
//     */
//    public static BaseResponse sessionFailure() {
//        return BaseResponse.failure()
//                .code(ErrorEnum.SESSION_EXPIRE.getCode())
//                .message(ErrorEnum.SESSION_EXPIRE.getDesc());
//    }

    /**
     * BaseResponse.
     */
    public BaseResponse(boolean success, int code, String message, Object data) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * BaseResponse.
     */
    public BaseResponse(boolean success) {
        super();
        this.success = success;
        this.code = success ? 200 : -1;
        this.message = success ? "成功" : "失败";

    }

    /**
     * BaseResponse.
     */
    public BaseResponse(boolean success, Object data) {
        super();
        this.success = success;
        this.data = data;
        this.code = success ? 200 : -1;
        this.message = success ? "成功" : "失败";
    }

    /**
     * BaseResponse.
     */
    public BaseResponse(boolean success, String message, Object data) {
        this(success, success ? 200 : -1, message, data);
    }

    /**
     * isSuccess.
     */
    public Boolean isSuccess() {
        return success;
    }

    /**
     * isSuccess.
     */
    public BaseResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    /**
     * getCode.
     */
    public int getCode() {
        return code;
    }

    /**
     * code.
     */
    public BaseResponse code(int code) {
        this.code = code;
        return this;
    }

    /**
     * getMessage.
     */
    public String getMessage() {
        return message;
    }

    /**
     * message.
     */
    public BaseResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * getData.
     */
    public Object getData() {
        return data;
    }

    /**
     * data.
     */
    public BaseResponse data(Object data) {
        this.data = data;
        return this;
    }
}