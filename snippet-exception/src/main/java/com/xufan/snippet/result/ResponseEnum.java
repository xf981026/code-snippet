package com.xufan.snippet.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Description:
 *
 * @Author xufan
 * @Create 2023/2/2 11:25
 */
@Getter
@AllArgsConstructor
@ToString
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    /**
     * 当异常找不到具体的处理了，会抛出该 message，发现系统异常就知道有 bug，但是没处理。
     */
    ERROR(-1, "系统异常"),

    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(101, "sql语法错误"),
    SERVLET_ERROR(102, "servlet请求异常"),
    UPLOAD_ERROR(103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),


    //-2xx 参数校验
    PASSWORD_NOT_EQUALS_ERROR(201, "两次密码输入不一致，请重新输入！"),
    EMAIL_ERROR(202, "请输入163邮箱或者qq邮箱！"),
    EMAIL_NOT_REGISTER_ERROR(203, "该邮箱未注册！"),
    INVALID_MAILBOX_FORMAT(299, "邮箱格式非法！"),
    EMAIL_EXSITS_ERROR(204, "邮箱已经注册"),
    CODE_NULL_ERROR(205, "验证码不能为空"),
    CODE_ERROR(206, "验证码错误"),
    VERIFICATION_CODE_EXPIRED(298, "验证码过期"),
    MOBILE_EXIST_ERROR(207, "手机号已被注册"),
    LOGIN_USER_NOT_EXSITS_ERROR(208, "用户不存在"),
    LOGIN_PASSWORD_ERROR(209, "密码错误"),
    PASSWORD_EXSITS_ERROR(210, "与之前密码一致，无需修改！"),

    LOGIN_AUTH_ERROR(211, "未登录"),

    LOGIN_LOKED_ERROR(219, "用户已被锁定"),


    /**
     * 关注相关
     */
    ATTENTION_NOT_MINE(301, "不能自己关注自己"),
    ATTENTION_EXISTS(302, "已经关注过该好友啦"),

    /**
     * 动态相关
     */
    ATTENTION_NUMBER_ERROR(401, "动态图片/视频的数量不能超过9个"),
    TEXT_AND_PICTURES_NOT_EXISTS(402, "文本和图片不允许同时不存在"),

    ALIYUN_RESPONSE_ERROR(501, "阿里云短信服务响应失败"),
    //业务限流
    ALIYUN_SMS_LIMIT_CONTROL_ERROR(502, "短信发送过于频繁"),
    //其他失败
    ALIYUN_SMS_ERROR(503, "短信发送失败"),
    OSS_URL_ILLEGALITY(504, "URL长度不正确"),
    OSS_URL_ERROR(505, "地址路径前缀错误"),

    WEIXIN_CALLBACK_PARAM_ERROR(601, "回调参数不正确"),
    WEIXIN_FETCH_ACCESSTOKEN_ERROR(602, "获取access_token失败"),
    WEIXIN_FETCH_USERINFO_ERROR(603, "获取用户信息失败"),
    ;


    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;
}
