package com.example.onenight.utils;

/**
 * 返回状态类
 *
 * @author ztx
 * @date 2020/4/3
 */
public class Result<T> {
    /** 登录错误 */
    public static final Integer ERR_LOGIN = 1;
    /** 校验错误 */
    public static final Integer ERR_VALIDATE = -1;

    /** 保存错误 */
    public static final Integer ERR_SAVE = 100;

    /** 更新错误 */
    public static final Integer ERR_UPDATE = 101;

    /** 删除错误 */
    public static final Integer ERR_DELETE = 102;

    /** 成功  */
    public static final Integer SUCCESS = 0;

    /** 异常  */
    public static final Integer ERR_EXCEPTION = -200;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T result;

    /** 成功标记 **/
    private Boolean success;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    @Override
    public String toString() {
        return "Result [code=" + code + ", msg=" + msg + ", result=" + result + ", success=" + success + "]";
    }
}
