package com.yilv.base.sys.authority.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.yilv.base.common.entity.DataEntity;

@Entity
@Table(name = "sys_role")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends DataEntity<Role> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	// Constructors

	/** default constructor */
	public Role() {
	}

	public Role(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}