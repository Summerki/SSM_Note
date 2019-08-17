package com.suki.dto;

import lombok.Data;

/**
 * DTO：数据传输对象
 * 自定义响应码
 */
@Data
public class ResponseCode {

    public static final int SUCCESS = 2000;

    public static final int FAIL = 4000;

    private Integer code;

    private String msg;

    private String detail;

}
