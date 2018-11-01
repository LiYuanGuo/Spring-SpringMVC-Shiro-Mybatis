package com.system.exception;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.system.util.result.ResultUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    全局异常处理器
 *    springmvc提供一个HandlerExceptionResolver接口
 *      只要实现该接口，并配置到spring 容器里，该类就能
 *      成为默认全局异常处理类
 *
 *   全局异常处理器只有一个，配置多个也没用。
 */
public class CustomExceptionResolver implements HandlerExceptionResolver,Ordered {
    
    private static Logger logger = LoggerFactory.getLogger(CustomExceptionResolver.class);

    private int order=Ordered.HIGHEST_PRECEDENCE;
    
    @Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return order;
	}
    
    public void setOrder(int order){
    	this.order=order;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = specialExceptionResolve(ex, request);
        if (null == mv) {
            String message = "系统异常，请联系管理员";
            mv = errorResult(message, "error", request);
        }
        return mv;
    }

    /**
     * 这个方法是拷贝 {@link org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver#doResolveException},
     * 加入自定义处理，实现对400， 404， 405， 406， 415， 500(参数问题导致)， 503的处理
     *
     * @param ex      异常信息
     * @param request 当前请求对象(用于判断当前请求是否为ajax请求)
     * @return 视图模型对象
     */
    private ModelAndView specialExceptionResolve(Exception ex, HttpServletRequest request) {
        try {
        	System.err.println(ex.getMessage());
        	if (ex instanceof NoHandlerFoundException) {
                return result(HttpExceptionEnum.NOT_FOUND, request);
            }else if (ex instanceof IllegalStateException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof HttpRequestMethodNotSupportedException) {
                return result(HttpExceptionEnum.METHOD_NOT_ALLOWED, request);
            }
            else if (ex instanceof HttpMediaTypeNotSupportedException) {
                return result(HttpExceptionEnum.UNSUPPORTED_MEDIA_TYPE, request);
            }
            else if (ex instanceof HttpMediaTypeNotAcceptableException) {
                return result(HttpExceptionEnum.NOT_ACCEPTABLE, request);
            }
            else if (ex instanceof MissingPathVariableException) {
                return result(HttpExceptionEnum.INTERNAL_SERVER_ERROR, request);
            }
            else if (ex instanceof MissingServletRequestParameterException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof ServletRequestBindingException) {
                return result(HttpExceptionEnum.INTERNAL_SERVER_ERROR, request);
            }
            else if (ex instanceof ConversionNotSupportedException) {
                return result(HttpExceptionEnum.INTERNAL_SERVER_ERROR, request);
            }
            else if (ex instanceof TypeMismatchException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof HttpMessageNotReadableException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof HttpMessageNotWritableException) {
                return result(HttpExceptionEnum.INTERNAL_SERVER_ERROR, request);
            }
            else if (ex instanceof MethodArgumentNotValidException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof MissingServletRequestPartException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof BindException) {
                return result(HttpExceptionEnum.BAD_REQUEST, request);
            }
            else if (ex instanceof AsyncRequestTimeoutException) {
                return result(HttpExceptionEnum.SERVICE_UNAVAILABLE, request);
            }else if (ex instanceof CustomException) {
            	return errorResult(ex.getMessage(), "error", request);
            } if(ex instanceof UnauthorizedException){
            	return result(HttpExceptionEnum.FORBIDDEN, request);
            }else if(ex instanceof UnknownAccountException){
            	return errorResult("用户不存在", "error", request);
            }else if (ex instanceof IncorrectCredentialsException) {
            	return errorResult("密码错误", "error", request);
            }
        } catch (Exception handlerException) {
            logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
        }
        return null;
    }

    /**
     * 判断是否ajax请求
     *
     * @param request 请求对象
     * @return true:ajax请求  false:非ajax请求
     */
    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"));
    }

    /**
     * 返回错误信息
     *
     * @param message 错误信息
     * @param url     错误页url
     * @param request 请求对象
     * @return 模型视图对象
     */
    private ModelAndView errorResult(String message, String url, HttpServletRequest request) {
        logger.warn("请求处理失败，请求url=[{}], 失败原因 : {}", request.getRequestURI(), message);
        if (isAjax(request)) {
            return jsonResult(500, message);
        } else {
            return normalResult(500,message, url);
        }
    }

    /**
     * 返回异常信息
     *
     * @param httpException 异常信息
     * @param request 请求对象
     * @return 模型视图对象
     */
    private ModelAndView result(HttpExceptionEnum httpException, HttpServletRequest request) {
        logger.warn("请求处理失败，请求url=[{}], 失败原因 : {}", request.getRequestURI(), httpException.reasonPhraseCN());
        if (isAjax(request)) {
            return jsonResult(httpException.code(), httpException.reasonPhraseCN());
        } else {
            return normalResult(httpException.code(),httpException.reasonPhraseCN(), "error");
        }
    }

    /**
     * 返回错误页
     *
     * @param message 错误信息
     * @param url     错误页url
     * @return 模型视图对象
     */
    private ModelAndView normalResult(int code,String message, String url) {
        Map<String, String> model = new HashMap<String, String>();
        model.put("code", String.valueOf(code));
        model.put("msg", message);
        return new ModelAndView(url, model);
    }

    /**
     * 返回错误数据
     *
     * @param message 错误信息
     * @return 模型视图对象
     */
    private ModelAndView jsonResult(int code, String message) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        view.setFastJsonConfig(fastJsonConfig);
        view.setAttributesMap((JSONObject) JSON.toJSON(ResultUtil.result(code, message,"")));
        mv.setView(view);
        return mv;
    }

}
