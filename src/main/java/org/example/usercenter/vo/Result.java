package org.example.usercenter.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @ClassName Response
 * @Description TODO
 * @Author lanran
 * @DATE 2025/7/18 10:29
 * @Version 1.0
 */
@Data
public class Result<T> {
    private int code;

    private String msg;

    private T data;

    public Result(T data, int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> of(T data, int code, String msg){
        return new Result<T>(data, code, msg);
    }

    public static <T> Result<T> success(T data) {
        return Result.of(data, 200, null);
    }

    public static <T> Result<T> success() {
        return Result.of(null, 200, null);
    }

    public static <T> Result<T> failure(int code, String msg) {
        return Result.of(null, code, msg);
    }
}
