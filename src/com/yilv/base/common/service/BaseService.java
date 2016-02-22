package com.yilv.base.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class BaseService<H, M> {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected H hDao;

	@Autowired
	protected M mDao;

}
