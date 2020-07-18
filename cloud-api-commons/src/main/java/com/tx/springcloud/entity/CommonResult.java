package com.tx.springcloud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {

    //404 not_found
    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }
}
