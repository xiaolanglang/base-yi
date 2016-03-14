package com.yilv.base.common.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<D> {
	@Autowired
	protected D dao;
}
