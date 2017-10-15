package com.gather.util;

public class PageUtil {
	public static int getStartIndex(int page,int pageSize)	{
		return (page-1)*pageSize;
	}
	
	public static int getEndIndex(int page,int pageSize,int total)	{
		int end=page*pageSize;
		if(end > total)	{
			end = total;
		}
		return end;
	}
	
	public static void main(String[] args) {
		int page=3;
		for(int i=10;i<30;i++)	{
			System.out.println(i+ " : start " + getStartIndex(page,10) + " , end " + getEndIndex(page,10,i));
		}
	}
}
