package com.yilv.base.modules.dongtai.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yilv.base.common.dao.impl.CrudDao;
import com.yilv.base.common.utils.hibernatepage.HPage;
import com.yilv.base.modules.dongtai.entity.DongTai;
import com.yilv.base.modules.dongtai.response.DongtaiMsg;

@Repository
public class CDongTaiDao extends CrudDao<DongTai> {

	public List<DongtaiMsg> findPageList(DongtaiMsg dongtaiMsg, boolean cacheable, HPage<DongtaiMsg> page,
			String associationPaths) {
		String sql = "select a.id AS 'id',a.content AS 'content',a.create_time AS 'create_time',a.position AS 'position',(select COUNT(*) FROM yi_dongtai_good WHERE dongtaiId = a.id) AS 'attitudesCount',acc.nickname AS 'account.nickname',acc.id AS 'account.id',acc.img AS 'account.img',a.create_by AS 'account' from yi_dongtai a INNER JOIN yi_account acc ON acc.id = a.create_by";
		@SuppressWarnings("unchecked")
		List<DongtaiMsg> list = getSession().createSQLQuery(sql).addEntity(DongtaiMsg.class).setCacheable(false).list();

		return list;
	}
}
