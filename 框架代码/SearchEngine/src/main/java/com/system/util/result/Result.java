/**
 * 
 */
package com.system.util.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @title Result.java
 * @author liyuanguo
 * @time 2018年7月16日 下午4:26:55
 * @description TODO
 * @version V1.0
 */
@ApiModel(description= "响应信息")
public class Result<T>{
    /*错误码*/
	@ApiModelProperty(value = "错误码 成功200 失败 500")
    private Integer code;
    /*提示信息*/
    @ApiModelProperty(value = "提示信息")
    private String msg;
    /*具体的内容*/
    @ApiModelProperty(value = "具体的数据")
    private T data;

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
	
	public T getData() {
	    return data;
	}
	
	public void setData(T data) {
	    this.data = data;
	}
}
