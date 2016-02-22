package com.yilv.base.common.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.dao.hibernate.HCrudDao;
import com.yilv.base.common.dao.mybatis.Basedao;
import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.common.service.BaseService;
import com.yilv.base.common.service.interfaces.ICrudService;
import com.yilv.base.common.utils.page.hibernate.HPage;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<H extends HCrudDao<T>, M extends Basedao<?>, T extends DataEntity<T>> extends
		BaseService<H, M> implements ICrudService<T> {

	@Override
	public T get(T entity, String... batchTable) {
		return hDao.get(entity, batchTable);
	}

	@Override
	public List<T> findPageList(T entity, boolean cacheable, HPage<T> page, String... associationPaths) {
		return hDao.findPageList(entity, cacheable, page, associationPaths);
	}

	@Override
	public List<T> findList(T entity, boolean cacheable, String... associationPaths) {
		return hDao.findList(entity, cacheable, associationPaths);
	}

	@Override
	public List<T> findAllList(Class<T> clz, boolean cacheable, String... associationPaths) {
		return hDao.findAllList(clz, cacheable, associationPaths);
	}

	@Override
	public List<?> sqlQueryList(String sql, Class<?> clz, boolean cacheable) {
		return hDao.sqlQueryList(sql, clz, cacheable);
	}

	@Override
	@Transactional(readOnly = false)
	public void save(T entity) {
		hDao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(T entity) {
		hDao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(T entity) {
		hDao.update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T entity) {
		hDao.delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void trueDelete(T entity) {
		hDao.trueDelete(entity);
	}

}
