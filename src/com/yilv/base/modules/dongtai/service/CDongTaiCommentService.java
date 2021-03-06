package com.yilv.base.modules.dongtai.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.dongtai.dao.HDongTaiCommentDao;
import com.yilv.base.modules.dongtai.dao.MDongTaiCommentDao;
import com.yilv.base.modules.dongtai.entity.DongTaiComment;

@Service
@Transactional(readOnly = true)
public class CDongTaiCommentService extends CrudService<HDongTaiCommentDao, MDongTaiCommentDao, DongTaiComment> {

}
