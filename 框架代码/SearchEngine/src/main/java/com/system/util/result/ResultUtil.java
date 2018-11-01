/**
 * 
 */
package com.system.util.result;

/**
 * @title ResultUtil.java
 * @author liyuanguo
 * @time 2018年7月16日 下午4:28:26
 * @description TODO
 * @version V1.0
 */

public class ResultUtil {

	/**
	 * 
	 * @author liyuanguo
	 * @time 2018年7月16日 下午4:36:49
	 * @description 
	 * @param code 成功200 失败 500 404未找到
	 * @param msg 提示信息
	 * @param data 返回的数据
	 */
    public static Result result(Integer code,String msg,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}