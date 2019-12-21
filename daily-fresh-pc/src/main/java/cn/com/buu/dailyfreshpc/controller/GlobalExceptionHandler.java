package cn.com.buu.dailyfreshpc.controller;


import cn.com.buu.dailyfreshpc.exception.UacBusinessException;
import cn.com.buu.dailyfreshpc.module.enums.UacErrorEnum;
import cn.com.buu.dailyfreshpc.module.vo.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * 全局的的异常拦截器
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数非法异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResult illegalArgumentException(IllegalArgumentException e) {
        log.error("参数非法异常={}", e.getMessage(), e);
        return BaseResult.failed(UacErrorEnum.UAC_NULL_PARAM);
    }

    /**
     * 业务异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(UacBusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResult businessException(UacBusinessException e) {
        log.error("业务异常={}", e.getMessage(), e);
        return BaseResult.failed(e.getCode() == 0 ? 9999 : e.getCode(), e.getMessage());
    }

    /**
     * 业务异常.
     *
     * @param e the e
     * @return the wrapper
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResult OtherException(Exception e) {
        log.error("系统异常={}", e.getMessage(), e);
        return BaseResult.failed(9999, "系统异常");
    }


}
