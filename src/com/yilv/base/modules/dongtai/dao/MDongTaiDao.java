package com.yilv.base.modules.dongtai.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yilv.base.common.dao.mybatis.Basedao;
import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.common.utils.page.mbatis.MPage;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.modules.dongtai.dao.interfaces.IDongTaiDao;
import com.yilv.base.modules.dongtai.response.DongtaiMsg;

@Component
public class MDongTaiDao extends Basedao<IDongTaiDao> {

	public List<DongtaiMsg> findMsgPageList(MPage<DongtaiMsg> page) {
		page.start();
		Account account = new Account(AccountUtils.getAccount().getId());
		List<DongtaiMsg> list = dao.findMsgPageList(account);
		page.end();
		return list;
	}

}
