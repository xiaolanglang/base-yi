package com.yilv.base.common.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.dao.impl.CrudDao;
import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.common.service.interfaces.ICrudService;
import com.yilv.base.common.utils.hibernatepage.HPage;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> implements ICrudService<T> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected D dao;

	@Override
	public T get(T entity, String... batchTable) {
		return dao.get(entity, batchTable);
	}

	@Override
	public List<T> findPageList(T entity, boolean cacheable, HPage<T> page, String... associationPaths) {
		return dao.findPageList(entity, cacheable, page, associationPaths);
	}

	@Override
	public List<T> findList(T entity, boolean cacheable, String... associationPaths) {
		return dao.findList(entity, cacheable, associationPaths);
	}

	@Override
	public List<T> findAllList(Class<?> clz, boolean cacheable, String... associationPaths) {
		return dao.findAllList(clz, cacheable, associationPaths);
	}

	@Override
	public List<?> sqlQueryList(String sql, Class<?> clz, boolean cacheable) {
		return dao.sqlQueryList(sql, clz, cacheable);
	}

	@Override
	@Transactional(readOnly = false)
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(T entity) {
		dao.saveOrUpdate(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void trueDelete(T entity) {
		dao.trueDelete(entity);
	}

}
