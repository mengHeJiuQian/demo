package com.metlife.wechat.enums;

import lombok.Getter;

/**
 * 功能描述：
 * 异常提示级错误码枚举.
 *
 * @version V1.0
 * @classname: com.metlife.wechat.modules.enums.ErrorEnum.java
 * @copyright Powered By wechat
 * @author: somnus
 * @date: 2019-10-19 15:35:04
 */
@Getter
public enum ErrorEnum implements BaseEnum<Integer> {

    SYSTEN_EXCEPTION(-1, "尊敬的客户，由于系统异常，请稍后重试！如果您有任何疑问，请致电我司客户服务热线：4008188168。"),

    BUSINESS_EXCEPTION_WITH_CODE(100010, "尊敬的客户，由于系统异常(%s)，请稍后重试！如您有任何疑问，请致电我司客户服务热线：4008188168。"),

    SUCCESS(200, "成功"),

    /**
     * 官微目前页面显示话术，只有上面三种.
     * 下面定义的各种异常，code最终会集成到第二个话术上的。最终呈现的效果，例如：尊敬的客户，由于系统异常(100001)，请稍后重试！如您有任何疑问，请致电我司客服电话400-818-8168.
     * 具体使用方式如下：.
     * BaseResponse.failure(ErrorEnum.BUSINESS【具体异常的枚举类型】).
     * 或.
     * throw new WeChatException(ErrorEnum.BUSINESS【具体异常的枚举类型】).
     */
    UNKNOWN_EXCEPTION(100001, "未知异常"),

    SERVICE_EXCEPTION(100002, "服务异常"),

    BUSINESS_EXCEPTION(100003, "业务异常"),

    INFO_EXCEPTION(100004, "提示级异常"),

    DB_EXCEPTION(100005, "数据库操作异常"),

    PARAM_EXCEPTION(100006, "参数异常"),

    SESSION_EXPIRE(100007, "session异常"),

    DIGEST_EXCEPTION(100008, "数据认证异常"),

    DUP_REQUEST_EXCEPTION(100009, "请勿重复提交请求"),

    NO_OPENID_IN_HEADER(400001, "请求头中获取不到用户openId"),

    NO_OPENID_IN_REDIS(400002, "redis中获取不到用户openId"),

    No_OPENID_IN_DB(400003, "数据库中获取不到用户openid"),

    WECHAT_TOKEN_ERROR(400005, "token获取失败");

//    /**
//     * 用户未绑定.
//     */
//    POINT_USER_NO_BIND_ERROR(1000,ConfigPropUtils.get("POINT_USER_NO_BIND_ERROR")),
//
//    /**
//     * 用户不存在积分账户.
//     */
//    POINT_USER_NO_ACCOUNT(1001,ConfigPropUtils.get("POINT_USER_NO_ACCOUNT")),
//
//    /**
//     * 证件有效期过期.
//     */
//    ID_CARD_EXPIRED(1004,ConfigPropUtils.get("REPAYMENT_ID_CARD_OVERDUE"));

    private Integer code;
    private String desc;

    ErrorEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
