package com.example.onenight.utils;

/**
 * 实现返回状态工具类
 *
 * @author ztx
 * @date 2020/4/3
 */
public class ResultUtils {
    public static Result<Object> success(String msg,Object object) {
        Result<Object> result = new Result<Object>();
        result.setCode(Result.SUCCESS);
        result.setMsg(msg);
        result.setResult(object);
        result.setSuccess(true);
        return result;
    }
    public static Result<Object> error(Integer code, String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }
    public static Result<Object> error(String msg) {
        Result<Object> result = new Result<Object>();
        result.setCode(Result.ERR_EXCEPTION);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }
}
