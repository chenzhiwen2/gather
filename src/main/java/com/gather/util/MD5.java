package com.gather.util;

import java.security.MessageDigest;
import java.util.Date;

public class MD5 {
	//小写形式
	public final static String toMD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	//大写形式
	public final static String toUpMD5(String s)	{
		String result = toMD5(s);
		if(result == null)	{
			return result;
		}
		return result.toUpperCase();
	}
	//小写形式
	public final static String toLowMD5(String s)	{
		String result = toMD5(s);
		if(result == null)	{
			return result;
		}
		return result.toLowerCase();
	}
	public static void main(String[] args) {
		Date now = new Date();
		String time = "" + now.getTime();
		String account = "dg-vanke@aimwx.com";
		String redirect = "http://app.aimapp.net/wx/tenant/home";
		//redirect = URLEncoder.encode(redirect);
		String key = "api.aimapp.net/ad";
		String str = account + time + redirect + key;
		
		String sign = toMD5(str);
		
		
		System.out.println(str);
		System.out.println(sign);
		
		String urlFormat = "http://app.aimapp.net/tenant/oauth/ad?adaccount=%s&timespan=%s&redirect=%s&sign=%s";
		String url = String.format(urlFormat,account,time,redirect,sign);
		System.out.println(url);
		
		
		System.out.println(toMD5("123321"));
	}
}