package com.whoiszxl.edu.exception;

import com.whoiszxl.edu.bean.ResponseResult;
import com.whoiszxl.edu.exception.custom.DataNullException;
import com.whoiszxl.edu.exception.custom.JwtAuthException;
import com.whoiszxl.edu.exception.custom.ValidateException;

/**
 * 异常捕获
 *
 * @author whoiszxl
 * @date 2021/3/17
 */
public class ExceptionCatcher {

    public static void catchAuthFailEx(){
        throw new JwtAuthException();
    }

    public static void catchValidateEx(ResponseResult result){
        throw new ValidateException(result);
    }

    public static void catchNullEx(ResponseResult result) {
        throw new DataNullException(result);
    }

}