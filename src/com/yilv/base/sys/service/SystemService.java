package com.yilv.base.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.security.shiro.session.SessionDAO;
import com.yilv.base.common.utils.AccountUtils;
import com.yilv.base.modules.account.dao.HAccountDao;
import com.yilv.base.modules.account.entity.Account;
import com.yilv.base.sys.authority.dao.AccountRoleDao;
import com.yilv.base.sys.authority.dao.PermissionsDao;
import com.yilv.base.sys.authority.dao.RoleDao;
import com.yilv.base.sys.authority.dao.RolePermissionsDao;
import com.yilv.base.sys.authority.entity.Permissions;
import com.yilv.base.sys.authority.entity.Role;
import com.yilv.base.sys.security.SystemAuthorizingRealm;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemService {

	@Autowired
	private HAccountDao accountDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RolePermissionsDao rolePerDao;
	@Autowired
	private AccountRoleDao accountRoleDao;
	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private SessionDAO sessionDao;
	@Autowired
	private SystemAuthorizingRealm systemRealm;

	public SessionDAO getSessionDao() {
		return sessionDao;
	}

	// -- account Service --//

	public Account get(Account account) {
		return accountDao.get(account);
	}

	public Account getAccountByUsername(Account account) {
		return accountDao.getAccountByUsername(account);
	}

	/**
	 * 登录
	 * 
	 * @param userName
	 * @param passWord
	 */
	public Account login(String userName, String passWord) {
		Account account = accountDao.login(userName, passWord);
		return account;
	}

	/**
	 * 获取用户
	 * 
	 * @param id
	 * @return
	 */
	public Account getAccount(String id) {
		return AccountUtils.get(id);
	}

	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return
	 */
	public Account getAccountByUsername(String loginName) {
		return AccountUtils.getByUsername(loginName);
	}

	// -- permissions -- //

	/**
	 * 找出所有的权限
	 * 
	 * @param permissions
	 * @return
	 */
	public List<Permissions> findAllPermissionsList() {
		return permissionsDao.findAllList(Permissions.class, false);
	}

	/**
	 * 根据账户找到对应权限
	 * 
	 * @param account
	 * @return
	 */
	public List<Permissions> findPermissionsByAccount(Account account) {
		return permissionsDao.getPermissionsByAccount(account);
	}

	// -- role -- //

	/**
	 * 找到所有角色
	 * 
	 * @return
	 */
	public List<Role> findAllRoleList() {
		return roleDao.findAllList(Role.class, false);
	}

	/**
	 * 根据账户找到角色
	 * 
	 * @param accountRole
	 * @return
	 */
	public List<Role> findRoleListByAccount(Account account) {
		return roleDao.findRoleListByAccount(account);
	}
}
