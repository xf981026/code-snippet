package com.xufan.snippet.exception;



import com.xufan.snippet.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *  自定义异常类：
 *  此类必须继承 RuntimeException，不能是 Exception，否则我们在代码中 throw new BusinessException(); 时会有报错的红线。
 *  一些其他说明：我们在抛出自定义异常时，代码是这么写的 throw new BusinessException(枚举对象);，所以该类的方法只需要构造方法。
 *  枚举对象有两个属性 code 和 message，所以该类也只需要两个属性去接收。
 * @Author xufan
 * @Create 2023/2/2 11:19
 */
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{

    //错误码
    private Integer code;
    //错误消息
    private String message;

    /**
     *
     * @param message 错误消息
     */
    public BusinessException(String message) {
        this.message = message;
    }

    /**
     *
     * @param message 错误消息
     * @param code 错误码
     */
    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param message 错误消息
     * @param code 错误码
     * @param cause 原始异常对象
     */
    public BusinessException(String message, Integer code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     */
    public BusinessException(ResponseEnum resultCodeEnum) {
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

    /**
     *
     * @param resultCodeEnum 接收枚举类型
     * @param cause 原始异常对象
     */
    public BusinessException(ResponseEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }
}
