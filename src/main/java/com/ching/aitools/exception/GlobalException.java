package com.ching.aitools.exception;

import com.ching.aitools.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e) {
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(value = {CustomException.class})
    public R exceptionHandler(CustomException e) {
        return R.fail(e.getResultCodeEnum());
    }
}
