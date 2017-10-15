package com.gather.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApiResult implements Serializable {
	private static final long serialVersionUID = -249748665065536230L;
	
	private static final Object defaultData = new HashMap<String, Object>();
    private int rescode = 0;
    private String resmsg = "";
    private Object data;

    public ApiResult(int code, String msg, Object data) {
        this.rescode = code;
        this.resmsg = msg;
        this.data = data;
    }

    public static ApiResult success() {
        return new ApiResult(0, "ok", defaultData);
    }

    public static ApiResult successWithObject(Object data) {
        return new ApiResult(0, "ok", data);
    }
    public static ApiResult successWithMap(String key,Object data) {
    	Map<String,Object> result = new HashMap<String,Object>();
    	result.put(key, data);
        return new ApiResult(0,"ok", result);
    }

    public static ApiResult error(String msg) {
        return new ApiResult(500, msg, defaultData);
    }

    public static ApiResult error(int code, String msg) {
        return new ApiResult(code, msg, defaultData);
    }
    
    public static ApiResult exception(BaseException e) {
        return new ApiResult(e.getCode(), e.getMessage(), defaultData);
    }
    
    public int getRescode() {
		return rescode;
	}

	public void setRescode(int rescode) {
		this.rescode = rescode;
	}

	public String getResmsg() {
		return resmsg;
	}

	public void setResmsg(String resmsg) {
		this.resmsg = resmsg;
	}

	public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}