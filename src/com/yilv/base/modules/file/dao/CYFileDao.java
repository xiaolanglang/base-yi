package com.yilv.base.modules.file.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yilv.base.common.dao.impl.CrudDao;
import com.yilv.base.modules.file.eitity.YFile;
import com.yilv.base.modules.file.response.YFileMin;

@Component
public class CYFileDao extends CrudDao<YFile> {

	@SuppressWarnings("unchecked")
	public List<YFileMin> findFilesByEntityIds(List<String> ids) {
		StringBuilder builder = new StringBuilder();
		for (String str : ids) {
			builder.append("'");
			builder.append(str);
			builder.append("'");
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		List<YFileMin> list = getSession()
				.createSQLQuery(
						"select id , url ,entity_id  from yi_file WHERE entity_id in (" + builder.toString() + ")")
				.addEntity(YFileMin.class).list();
		return list;
	}
}
