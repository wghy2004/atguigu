package com.atguigu.sys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysUser implements Identifiable {

	private Long id;

	private String email;

	private String password;

	private String salt;

	private String uri;

	private String nickname;

	private String title;

	private String tags;

	private String type;

	private Integer point;

	private Integer coin;

	private String smallAvatar;

	private String mediumAvatar;

	private String largeAvatar;

	private Boolean emailVerified;

	private Byte setup;

	private String roles;

	private Byte promoted;

	private Integer promotedTime;

	private Byte locked;

	private Integer loginTime;

	private String loginIp;

	private String loginSessionId;

	private Integer approvalTime;

	private String approvalStatus;

	private Integer newMessageNum;

	private Integer newNotificationNum;

	private String createdIp;

	private String createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri == null ? null : uri.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public String getSmallAvatar() {
		return smallAvatar;
	}

	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar == null ? null : smallAvatar.trim();
	}

	public String getMediumAvatar() {
		return mediumAvatar;
	}

	public void setMediumAvatar(String mediumAvatar) {
		this.mediumAvatar = mediumAvatar == null ? null : mediumAvatar.trim();
	}

	public String getLargeAvatar() {
		return largeAvatar;
	}

	public void setLargeAvatar(String largeAvatar) {
		this.largeAvatar = largeAvatar == null ? null : largeAvatar.trim();
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Byte getSetup() {
		return setup;
	}

	public void setSetup(Byte setup) {
		this.setup = setup;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles == null ? null : roles.trim();
	}

	public Byte getPromoted() {
		return promoted;
	}

	public void setPromoted(Byte promoted) {
		this.promoted = promoted;
	}

	public Integer getPromotedTime() {
		return promotedTime;
	}

	public void setPromotedTime(Integer promotedTime) {
		this.promotedTime = promotedTime;
	}

	public Byte getLocked() {
		return locked;
	}

	public void setLocked(Byte locked) {
		this.locked = locked;
	}

	public Integer getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Integer loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp == null ? null : loginIp.trim();
	}

	public String getLoginSessionId() {
		return loginSessionId;
	}

	public void setLoginSessionId(String loginSessionId) {
		this.loginSessionId = loginSessionId == null ? null : loginSessionId
				.trim();
	}

	public Integer getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Integer approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus == null ? null : approvalStatus
				.trim();
	}

	public Integer getNewMessageNum() {
		return newMessageNum;
	}

	public void setNewMessageNum(Integer newMessageNum) {
		this.newMessageNum = newMessageNum;
	}

	public Integer getNewNotificationNum() {
		return newNotificationNum;
	}

	public void setNewNotificationNum(Integer newNotificationNum) {
		this.newNotificationNum = newNotificationNum;
	}

	public String getCreatedIp() {
		return createdIp;
	}

	public void setCreatedIp(String createdIp) {
		this.createdIp = createdIp == null ? null : createdIp.trim();
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}