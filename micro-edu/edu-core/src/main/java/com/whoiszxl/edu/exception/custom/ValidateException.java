package com.whoiszxl.edu.exception.custom;

import com.whoiszxl.edu.bean.ResponseResult;

/**
 * 校验异常
 *
 * @author whoiszxl
 * @date 2021/3/17
 */
public class ValidateException extends RuntimeException {

    //错误代码
    private final ResponseResult result;

    public ValidateException(ResponseResult result){
        this.result = result;
    }
    public ResponseResult getResult(){
        return result;
    }
}