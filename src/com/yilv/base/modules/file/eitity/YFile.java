package com.yilv.base.modules.file.eitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yilv.base.common.entity.DataEntity;

/**
 * YFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_file")
public class YFile extends DataEntity<YFile> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Double size;
	private String url;
	private String localpath;
	private String entityId;
	private String type;

	// Constructors

	/** default constructor */
	public YFile() {
	}

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "size", precision = 255)
	public Double getSize() {
		return this.size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "localpath")
	public String getLocalpath() {
		return this.localpath;
	}

	public void setLocalpath(String localpath) {
		this.localpath = localpath;
	}

	@Column(name = "type", length = 1)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "entity_id", length = 32)
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

}