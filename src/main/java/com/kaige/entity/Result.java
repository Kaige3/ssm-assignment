package com.kaige.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result <T>{
    private int code;
    private String msg;
    private T data;

    // 静态方法，返回成功的结果（包含 code、msg 和 data）
    public static <T> Result<T> success(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    // 静态方法，返回成功的结果（仅包含 code 和 msg）
    public static <T> Result<T> success(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    // 静态方法，返回成功的结果（仅包含 data）
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);  // 默认 code 200 和 "操作成功"
    }


    // 静态方法，返回失败的结果（包含 code 和 msg）
    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    // 静态方法，返回失败的结果（仅包含 msg）
    public static <T> Result<T> error(String msg) {
        return new Result<>(500, msg, null);  // 默认 code 500
    }

    // 静态方法，返回失败的结果（仅包含 data 为 null）
    public static <T> Result<T> error(T data) {
        return new Result<>(500, "操作失败", data);  // 默认 code 500 和 "操作失败"
    }

}
