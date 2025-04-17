package com.ching.aitools.exception;

import com.ching.aitools.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private Integer code; // 错误码

    private String message; // 错误信息

    private ResultCodeEnum resultCodeEnum; // 错误枚举

    public CustomException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.resultCodeEnum = resultCodeEnum;
    }

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
