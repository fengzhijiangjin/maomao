package com.wxinnb.maomao.exception;

/**
 * Author: lnp
 * Date: 2018/11/25
 **/
public class RuleImportException extends RuntimeException {
    //自定义错误码
    private Integer code;
    //自定义构造器，只保留一个，让其必须输入错误码及内容
    public RuleImportException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
