package com.yilv.base.modules.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.account.dao.CAccountDao;
import com.yilv.base.modules.account.entity.Account;

@Service
@Transactional(readOnly = true)
public class CAccountService extends CrudService<CAccountDao, Account> {

}
