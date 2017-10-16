package com.gather.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gather.common.BasePageDto;
import com.gather.common.PageDto;
import com.gather.dao.AccountDao;
import com.gather.model.Account;
import com.gather.util.ApiResult;
import com.gather.util.MD5;
import com.gather.util.PageUtil;
import com.gather.util.StringUtil;

/**
 * 
 * @author czw
 *
 * 2017年10月2日上午11:42:34
 *
 * 类说明：控制层
 */
@RequestMapping(value = "/account")
@Controller
public class AccountController extends BaseController{
	
	@Autowired
	private AccountDao accountDao;
	
	/**
	 * 新增用户
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/create_account")
	@ResponseBody
	public ApiResult createAccount(Account a) {
		if(null == a){
			return ApiResult.error(-99, isNotNull);
		}
		Account account = accountDao.getAccountName(a.getAccountName());
		if(null != account){
			return ApiResult.error(-4, isNameExist);
		}
		a.setPswd(MD5.toLowMD5(a.getPswd()));
		accountDao.createAccount(a);
		return ApiResult.success();
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_account")
	@ResponseBody
	public ApiResult deleteAccount(Integer id){
		accountDao.deleteAccount(id);
		return ApiResult.success();
	}
	
	/**
	 * 获取全部用户
	 * @return
	 */
	@RequestMapping(value = "/account_list")
	@ResponseBody
	public ApiResult accountList(Account a){
		a.setStart(PageUtil.getStartIndex(a.getPage(), a.getPageSize()));
		List<Account> list = accountDao.accountList(a);
		PageDto page = new PageDto(a.getPage(), a.getPageSize(),accountDao.listNum(a));
		return ApiResult.successWithObject(new BasePageDto(list, page));
	}
	
	/**
	 * 修改用户信息
	 * @param a
	 * @return
	 */
	@RequestMapping(value = "/update_account")
	@ResponseBody
	public ApiResult updateAccount(Account a){
		if(null == a){
			return ApiResult.error(-99, isNotNull);
		}
		Account account = accountDao.getAccountName(a.getAccountName());
		if(null != account){
			if(!account.getId().equals(a.getId())){
				return ApiResult.error(-4, isNameExist);
			}
		}
		accountDao.updateAccount(a);
		return ApiResult.success();
	}
	
	/**
	 * 修改密码
	 * @param newPswd
	 * @param oldPswd
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update_pswd")
	@ResponseBody
	public ApiResult updatePswd(String newPswd,String oldPswd,Integer id){
		Account a = accountDao.getAccount(id);
		if(!a.getPswd().equals(MD5.toLowMD5(oldPswd))){
			return ApiResult.error(-2, isPswdError);
		}
		accountDao.updatePswd(MD5.toLowMD5(newPswd), id);
		return ApiResult.success();
	}
	
	/**
	 * 重置密码
	 * @param pswd
	 * @param id
	 * @return
	 */
	public ApiResult ResetPswd(String pswd,Integer id){
		accountDao.updatePswd(MD5.toLowMD5("123321"), id);
		return ApiResult.success();
	}
	
	/**
	 * 获取单个用户信息
	 * @return
	 */
	@RequestMapping(value = "/get_account")
	@ResponseBody
	public ApiResult getAccount(){
		Account a = accountDao.getAccount(1);
		return ApiResult.successWithObject(a);
	}
	
	/**
	 * 登陆验证
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ApiResult login(HttpServletRequest request) {
		String accountName = request.getParameter("account_name");
		String pswd = request.getParameter("pswd");
		if(StringUtil.isEmpty(accountName) || StringUtil.isEmpty(pswd)) {
			return ApiResult.error(-99, isNotNull);
		}
		Account a = accountDao.getAccountName(accountName);
		if(null == a){
			return ApiResult.error(-1, isAccountNameNull);
		}
		if(a.getPswdErrorNum() > 5){
			return ApiResult.error(-3, isPswdErrorNum);
		}
		if(!a.getPswd().equals(MD5.toLowMD5(pswd))){
			accountDao.updatePswdNum(a.getId(), a.getPswdErrorNum()+1);
			return ApiResult.error(-2, isPswdError);
		}
		accountDao.updatePswdNum(a.getId(), 0);
		saveLoginInfo(request, a);
		return ApiResult.success();
	}
	
	/**
	 * 注销方法
	 * @param request
	 */
	@RequestMapping(value = "/toLogin")
	@ResponseBody
	public void toLogin(HttpServletRequest request){
		HttpSession session  = request.getSession();
		session.invalidate();
	}
}
