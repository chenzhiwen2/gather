package com.gather.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.gather.model.Account;

public class BaseController {
	protected static String isAccountNameNull = "该用户名不存在，请确认后操作！";//-1
	protected static String isPswdError = "密码错误，请重新输入！";//-2
	protected static String isPswdErrorNum = "密码连续错误五次，账号已被冻结，请联系管理员！";//-3
	protected static String isNotNull = "传入参数不能为空，请重新输入！";//-99
	protected static String isSessionNull = "用户登录已失效，请重新登录！";//-98
	protected static String isNameExist = "该名称已被使用，请重新选择！";//-4
	
	public void saveLoginInfo(HttpServletRequest request,Account a){
		HttpSession session = request.getSession();
		session.setAttribute("accountInfo", a);
	}
	
	protected Integer getParameterInt(HttpServletRequest request,String key,Integer defaultValue)	{
		try	{
			return Integer.parseInt(request.getParameter(key));
		}catch(Exception e)	{
			return defaultValue;
		}
	}
	protected Integer getParameterInt(HttpServletRequest request,String key)	{
		return Integer.parseInt(request.getParameter(key));
	}
	protected String getParameterStr(HttpServletRequest request,String key)	{
		String value = request.getParameter(key);
		return value;
	}
	protected String getParameterStr(HttpServletRequest request,String key,String defaultValue)	{
		String value = request.getParameter(key);
		if(StringUtils.isEmpty(value))	{
			return defaultValue;
		}
		return value;
	}

}
