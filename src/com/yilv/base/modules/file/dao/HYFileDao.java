package com.yilv.base.modules.file.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yilv.base.common.dao.hibernate.HCrudDao;
import com.yilv.base.modules.file.eitity.YFile;
import com.yilv.base.modules.file.response.YFileMin;

@Component
public class HYFileDao extends HCrudDao<YFile> {

	public List<YFileMin> findFilesByEntityIds(List<String> ids) {
		StringBuilder builder = new StringBuilder();
		builder.append("select id , url ,entity_id  from yi_file WHERE entity_id in (");
		for (String str : ids) {
			builder.append("'");
			builder.append(str);
			builder.append("'");
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(")");
		return sqlQueryList(builder.toString(), YFileMin.class, true);
	}
}
