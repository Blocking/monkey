package com.look.monkey.bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * @author zhangxiaoyu
 */
public class ResultEntity<T> extends ResponseEntity<T> {

    private String errorMessage;

    public ResultEntity(HttpStatus status) {
        super(status);
    }

    public ResultEntity(T body, HttpStatus status) {
        super(body, status);
    }
    public ResultEntity(String errorMessage,T body,HttpStatus status) {
        super(body, status);
        this.errorMessage = errorMessage;
    }

    public ResultEntity(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public ResultEntity(T body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }
    public boolean isSuccess(){
        return HttpStatus.OK == getStatusCode();
    }
    public boolean isFailure(){
        return HttpStatus.OK != getStatusCode();
    }

    public static <T> ResultEntity<T> success(T body) {
        return new ResultEntity<>(body,HttpStatus.OK);
    }
    public static <T> ResultEntity<T> success() {
        return new ResultEntity<>(null,HttpStatus.OK);
    }
    public static <T> ResultEntity<T> failure(String errorMessage) {
//        new ResultEntity(errorMessage,null,HttpStatus.NOT_ACCEPTABLE);
        return new ResultEntity<T>(errorMessage,null,HttpStatus.NOT_ACCEPTABLE);
    }
    public static <T> ResultEntity<T> failure() {
        return new ResultEntity<T>("",null,HttpStatus.NOT_ACCEPTABLE);
    }
}
