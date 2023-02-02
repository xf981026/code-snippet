package com.xufan.snippet.exception;

import com.xufan.snippet.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Description:
 * 该类是全局异常处理类：
 * 异常处理有三种：全局处理、特定处理、自定义处理
 * @Author xufan
 * @Create 2023/2/2 11:19
 */
@Slf4j
@RestControllerAdvice // 该类能处理系统所有的异常是因为有这个注解 @ControllerAdvice
public class UnifiedExceptionhandler {

    /**
     * 捕获全局处理：当异常过来找不到具体的子类异常处理时，会找到该方法处理
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error();
    }

    /**
     * 捕获特定处理：这种类型是针对于特定的异常做处理。此例子是处理前端传参是否为空等最基本校验。
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return R.error().message(objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public R handleException(HttpRequestMethodNotSupportedException e){
        log.error(e.getMessage(), e);
        return R.error().message("请求方式错误");
    }

    /**
     * 捕获自定义处理：首先需要一个自定义异常类 BusinessException。
     * 当我们在业务代码中写 throw new BusinessException(枚举对象)，就会找到该方法处理
     */
    @ExceptionHandler(value = BusinessException.class)
    public R handleException(BusinessException e){
        log.error(e.getMessage(), e);
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}