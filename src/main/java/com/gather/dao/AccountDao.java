package com.gather.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gather.model.Account;

/**
 * 
 * @author czw
 *
 * 2017年10月2日上午11:36:35
 *
 * 类说明：dao层借口
 */
public interface AccountDao {
	Account getAccount(Integer id);
	Account getAccountName(String name);
	int updatePswdNum(@Param("id") Integer id,@Param("errorNum") Integer errorNum);
	int createAccount(Account a);
	void deleteAccount(Integer id);
	int updateAccount(Account a);
	List<Account> accountList(Account a);
	int listNum(Account a);
	int updatePswd(@Param("pswd") String pswd,@Param("id") Integer id);
}
