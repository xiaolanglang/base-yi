package com.yilv.base.common.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<D extends MCrudDao<?>> {
	@Autowired
	protected D dao;
}
