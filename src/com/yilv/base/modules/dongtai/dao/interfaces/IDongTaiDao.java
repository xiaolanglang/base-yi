package com.yilv.base.modules.dongtai.dao.interfaces;

import java.util.List;

import com.yilv.base.common.dao.mybatis.MCrudDao;
import com.yilv.base.common.dao.mybatis.MyBatisDao;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.response.DongtaiMsg;

@MyBatisDao
public interface IDongTaiDao extends MCrudDao<DongTai> {

	List<DongtaiMsg> findMsgPageList();

}
