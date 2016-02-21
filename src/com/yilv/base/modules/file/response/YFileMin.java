package com.yilv.base.modules.file.response;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yilv.base.common.entity.BaseEntity;

@Entity
@Table(name = "yi_file")
public class YFileMin extends BaseEntity<YFileMin> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String entityId;

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "entity_id", length = 32)
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

}
