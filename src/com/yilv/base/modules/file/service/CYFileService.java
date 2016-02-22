package com.yilv.base.modules.file.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.file.dao.HYFileDao;
import com.yilv.base.modules.file.dao.MYFileDao;
import com.yilv.base.modules.file.eitity.YFile;

@Service
@Transactional(readOnly = true)
public class CYFileService extends CrudService<HYFileDao, MYFileDao, YFile> {

}
