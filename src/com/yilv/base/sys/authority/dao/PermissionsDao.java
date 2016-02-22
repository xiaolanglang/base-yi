package com.yilv.base.sys.authority.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yilv.base.common.dao.hibernate.HCrudDao;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.sys.authority.entity.Permissions;

@Repository
public class PermissionsDao extends HCrudDao<Permissions> {

	@SuppressWarnings("unchecked")
	public List<Permissions> getPermissionsByAccount(Account account) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sys_permission a ");
		stringBuilder.append("JOIN sys_role_permission rp on rp.per_id = a.id ");
		stringBuilder.append("JOIN sys_account_role ar on ar.role_id = rp.role_id ");
		stringBuilder.append("WHERE ar.account_id = :id ");
		return getSession().createSQLQuery(stringBuilder.toString()).addEntity(Permissions.class)
				.setString("id", account.getId()).list();
	}
}
