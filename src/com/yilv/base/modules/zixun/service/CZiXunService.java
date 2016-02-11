package com.yilv.base.modules.zixun.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.zixun.dao.CZiXunDao;
import com.yilv.base.modules.zixun.entity.ZiXun;

@Service
@Transactional(readOnly = true)
public class CZiXunService extends CrudService<CZiXunDao, ZiXun> {

}
