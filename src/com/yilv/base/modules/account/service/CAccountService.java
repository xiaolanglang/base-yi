package com.yilv.base.modules.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.account.dao.HAccountDao;
import com.yilv.base.modules.account.dao.MAccountDao;
import com.yilv.base.modules.account.entity.Account;

@Service
@Transactional(readOnly = true)
public class CAccountService extends CrudService<HAccountDao, MAccountDao, Account> {
	/**
	 * 登录
	 * 
	 * @param userName
	 * @param passWord
	 */
	public Account login(String userName, String passWord) {
		Account account = hDao.login(userName, passWord);
		return account;
	}
}
