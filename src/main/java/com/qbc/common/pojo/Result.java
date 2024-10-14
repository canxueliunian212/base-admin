package com.qbc.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassNme Result
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/14 11:53
 * @Version 1.0
 **/
@Data
public class Result<T> implements Serializable {


    private T data;

    private boolean flag = true;

    private String msg = "操作成功";


    public static  <T> Result<T> of(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> of(T data, boolean flag) {
        return new Result<>(data, flag);
    }

    public static <T> Result<T> of(T data, boolean flag, String msg) {
        return new Result<>(data, flag, msg);
    }

    @Deprecated
    public Result() {

    }

    private Result(T data) {
        this.data = data;
    }

    private Result(T data, boolean flag) {
        this.data = data;
        this.flag = flag;
    }

    private Result(T data, boolean flag, String msg) {
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }

}
