package com.yilv.base.modules.dongtai.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.dongtai.dao.HDongTaiGoodDao;
import com.yilv.base.modules.dongtai.dao.MDongTaiGoodDao;
import com.yilv.base.modules.dongtai.entity.DongTaiGood;

@Service
@Transactional(readOnly = true)
public class CDongTaiGoodService extends CrudService<HDongTaiGoodDao, MDongTaiGoodDao, DongTaiGood> {

}
