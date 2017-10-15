package com.gather.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StringUtil {
	public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
    public static String trimBlank(String str)    {
        return str.replaceAll("\\s*|\t|\r|\n","");
    }
    
    private static String getFixedLenthStr(char fill,int length)    {
        String temp = "";
        for(int i=0;i<length;i++)   {
            temp = temp + fill;
        }
        return temp;
    }
    //convert null string to ""
    public static String nullGuard(String str)   {
        if(str == null)    {
            return "";
        }
        return str;
    }
    public static String nullGuard(Object obj)   {
        if(obj == null)    {
            return "";
        }
        return obj.toString();
    }
    // fill to fixed length before the string
    public static String fillBefore(String str,char fill,int length)  {
        str = nullGuard(str);
        int need = length - str.length();
        return getFixedLenthStr(fill,need) + str;
    }
    // fill to fixed length after the string
    public static String fillAfter(String str,char fill,int length)  {
        str = nullGuard(str);
        int need = length - str.length();
        return str + getFixedLenthStr(fill,need);
    }
    public static String formatStr(Object str) {
        return (str == null) ? "" : (String) str;
    }

    public static String deleteFirst(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(1, str.length());
    }
    public static String deleteFirst(String str, char c) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.charAt(0) == c) {
            return str.substring(1, str.length());
        }
        return str;
    }
    
    
    
    public static String deleteLast(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
    
    public static String deleteLast(String str, char c) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.charAt(str.length() - 1) == c) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
    public static StringBuffer deleteLast(StringBuffer sb) {
        if (sb == null || sb.length() == 0) {
            return sb;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb;
    }
    public static StringBuffer deleteLast(StringBuffer sb, char c) {
        if (sb == null || sb.length() == 0) {
            return sb;
        }
        if (sb.charAt(sb.length() - 1) == c) {
        	sb.deleteCharAt(sb.length()-1); 
            return sb;
        }
        return sb;
    }
    
    public static StringBuffer deleteLast(StringBuffer sb, int n) {
        if (sb == null || sb.length() == 0) {
            return sb;
        }
        int len = sb.length();
        if (len >= n) {
        	sb.delete(len-n, len);
            return sb;
        }
        return sb;
    }
    public static String getExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getDateString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getDateString(long longTime, String format) {
        Date date = new Date(longTime);
        return getDateString(date, format);
    }
    public static String listToStr(List<String> strList)   {
        String idStr = "";
        for(String str : strList)   {
            idStr = idStr +  str + ",";
        }
        return deleteLast(idStr,',');
    }
    public static String fixedUrl(String url,int length)	{
    	url = nullGuard(url);
    	StringBuffer sb = new StringBuffer();
    	int len = url.length();
    	while(len > length)	{
    		sb.append(url.subSequence(0,length));
    		sb.append("<br />");
    		url = url.substring(length);
    		len = url.length();
    	}
    	sb.append(url);
    	return sb.toString();
    }
    //把 [1,2,5] 变成 "1,2,5"的字符串
    public static String listInt2Str(List<Integer> list)	{
    	String str = "";
    	for(Integer obj : list)	{
    		str = str + obj + ",";
    	}
    	return deleteLast(str,',');
    }
    public static String replaceLineBreak(String str,String target)	{
    	if(str == null)	{
    		return str;
    	}
    	return str.replaceAll("\r\n",target).replaceAll("\n",target);
    }
    
    public static Integer str2Int(String str,Integer defaultValue)	{
		try	{
			return Integer.parseInt(str);
		}catch(Exception e)	{
			return defaultValue;
		}
	}
    public static Integer str2Int(String str)	{
		try	{
			return Integer.parseInt(str);
		}catch(Exception e)	{
			return null;
		}
	}
    //"abc,def"  => "'abc','def'"
    public static String str2InFormat(String str)	{
    	if(str == null)	{
    		return str;
    	}
    	return "'"+str.replaceAll(",","','")+"'";
    }
    
    public static String obj2StrSafe(Object object){
    	try {
    		return object.toString();
		} catch (Exception e) {
			return null;
		}
    }
    
    public static void main(String[] args) {
    	String str = "abc,def";
    	System.out.println(str2InFormat(str));
	}

}
