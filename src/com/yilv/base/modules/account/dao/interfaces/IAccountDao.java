package com.yilv.base.modules.account.dao.interfaces;

import com.yilv.base.common.dao.mybatis.MCrudDao;
import com.yilv.base.common.dao.mybatis.MyBatisDao;
import com.yilv.base.modules.account.entity.Account;

@MyBatisDao
public interface IAccountDao extends MCrudDao<Account> {

}
