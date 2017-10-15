package com.gather.model;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author czw
 *
 * 2017年10月2日上午11:26:04
 *
 * 类说明：用户实体类
 */
public @Data class Account {
	//用户id
    private Integer id;
    //用户登录名
    private String accountName;
    //用户真实姓名
    private String userName;
    //密码
    private String pswd;
    //身份证号码
    private String identityId;
    //邮箱
    private String email;
    //状态 'ok:正常','frozen:冻结','locking:锁定','delete:已删除'
    private String status;
    //电话
    private String phone;
    //省份id
    private Integer provinceId;
    //市id
    private Integer cityId;
    //区县id
    private Integer districtId;
    //详细地址
    private String address;
    //密码错误次数
    private Integer pswdErrorNum;
    //创建时间
    private Date ctm;
    //创建时间
    private String sctm;
    //页数 
    private Integer page;
    //开始页
	private Integer start;		
	//总页数
	private Integer pageSize;
 
	
}
