package com.atguigu.sys.domain;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysFile implements Identifiable {
	private Integer id;

	private Integer groupId;

	private Integer userId;

	private String uri;

	private String mime;

	private Integer size;

	private Byte status;

	private Integer createdTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Integer createdTime) {
		this.createdTime = createdTime;
	}
}