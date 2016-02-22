package com.yilv.base.sys.authority.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yilv.base.common.dao.hibernate.HCrudDao;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.sys.authority.entity.Role;

@Repository
public class RoleDao extends HCrudDao<Role> {

	@SuppressWarnings("unchecked")
	public List<Role> findRoleListByAccount(Account account) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from sys_role r ");
		buffer.append("join sys_account_role ar on ar.role_id = r.id ");
		buffer.append("where ar.account_id = :id ");
		return getSession().createSQLQuery(buffer.toString()).addEntity(Role.class).setString("id", account.getId())
				.list();
	}

}
