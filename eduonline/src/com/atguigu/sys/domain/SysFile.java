package com.atguigu.sys.domain;

import java.sql.Timestamp;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysFile implements Identifiable {
	private Long id;

	private Long groupId;

	private Long userId;

	private String uri;

	private String mime;

	private Integer size;

	private Integer status;

	private Timestamp createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri == null ? null : uri.trim();
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime == null ? null : mime.trim();
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}