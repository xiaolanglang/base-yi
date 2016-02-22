package com.yilv.base.modules.dongtai.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.dongtai.dao.HDongTaiDao;
import com.yilv.base.modules.dongtai.dao.MDongTaiDao;
import com.yilv.base.modules.dongtai.entity.DongTai;

@Service
@Transactional(readOnly = true)
public class CDongTaiService extends CrudService<HDongTaiDao, MDongTaiDao, DongTai> {

}
