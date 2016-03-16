package com.yilv.base.modules.account.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.yilv.base.common.dao.hibernate.HCrudDao;
import com.yilv.base.common.utils.page.hibernate.HPage;
import com.yilv.base.modules.account.entity.Account;

@Repository
public class HAccountDao extends HCrudDao<Account> {
	public Account login(String userName, String passWord) {
		Criteria criteria = getCriteria(Account.class);
		criteria.add(Restrictions.eq("username", userName));
		criteria.add(Restrictions.eq("password", passWord));
		criteria.setCacheable(false);
		@SuppressWarnings("unchecked")
		List<Account> list = criteria.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Account getAccountByUsername(Account account) {
		Criteria criteria = getCriteria(Account.class);
		criteria.add(Restrictions.eq("username", account.getUsername()));
		@SuppressWarnings("unchecked")
		List<Account> list = criteria.list();
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public void findPageListByNickname(Account account, boolean cache, HPage<Account> page) {
		Criteria criteria = getCriteria(Account.class);
		Criterion c = Restrictions.like("nickname", account.getNickname(), MatchMode.ANYWHERE);
		criteria.add(c);
		page.init(page, criteria);
		criteria.setCacheable(cache);
		List<Account> list = criteria.list();
		page.setList(list);
	}
}
