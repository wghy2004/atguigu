package com.atguigu.sys.domain;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysCourse implements Identifiable {
	
	private Integer id;

	private String title;

	private String subtitle;

	private String status;

	private String type;

	private Integer maxStudentNum;

	private Float price;

	private Integer expiryDay;

	private String showStudentNumType;

	private String serializeMode;

	private Float income;

	private Integer lessonNum;

	private Integer giveCredit;

	private Integer rating;

	private Integer ratingNum;

	private Integer vipLevelId;

	private Integer categoryId;

	private String smallPicture;

	private String middlePicture;

	private String largePicture;

	private Byte recommended;

	private Integer recommendedSeq;

	private Integer recommendedTime;

	private Integer locationId;

	private String address;

	private Integer studentNum;

	private Integer hitNum;

	private Integer userId;

	private Integer createdTime;

	private Integer freeStartTime;

	private Integer freeEndTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle == null ? null : subtitle.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getMaxStudentNum() {
		return maxStudentNum;
	}

	public void setMaxStudentNum(Integer maxStudentNum) {
		this.maxStudentNum = maxStudentNum;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getExpiryDay() {
		return expiryDay;
	}

	public void setExpiryDay(Integer expiryDay) {
		this.expiryDay = expiryDay;
	}

	public String getShowStudentNumType() {
		return showStudentNumType;
	}

	public void setShowStudentNumType(String showStudentNumType) {
		this.showStudentNumType = showStudentNumType == null ? null
				: showStudentNumType.trim();
	}

	public String getSerializeMode() {
		return serializeMode;
	}

	public void setSerializeMode(String serializeMode) {
		this.serializeMode = serializeMode == null ? null : serializeMode
				.trim();
	}

	public Float getIncome() {
		return income;
	}

	public void setIncome(Float income) {
		this.income = income;
	}

	public Integer getLessonNum() {
		return lessonNum;
	}

	public void setLessonNum(Integer lessonNum) {
		this.lessonNum = lessonNum;
	}

	public Integer getGiveCredit() {
		return giveCredit;
	}

	public void setGiveCredit(Integer giveCredit) {
		this.giveCredit = giveCredit;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(Integer ratingNum) {
		this.ratingNum = ratingNum;
	}

	public Integer getVipLevelId() {
		return vipLevelId;
	}

	public void setVipLevelId(Integer vipLevelId) {
		this.vipLevelId = vipLevelId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSmallPicture() {
		return smallPicture;
	}

	public void setSmallPicture(String smallPicture) {
		this.smallPicture = smallPicture == null ? null : smallPicture.trim();
	}

	public String getMiddlePicture() {
		return middlePicture;
	}

	public void setMiddlePicture(String middlePicture) {
		this.middlePicture = middlePicture == null ? null : middlePicture
				.trim();
	}

	public String getLargePicture() {
		return largePicture;
	}

	public void setLargePicture(String largePicture) {
		this.largePicture = largePicture == null ? null : largePicture.trim();
	}

	public Byte getRecommended() {
		return recommended;
	}

	public void setRecommended(Byte recommended) {
		this.recommended = recommended;
	}

	public Integer getRecommendedSeq() {
		return recommendedSeq;
	}

	public void setRecommendedSeq(Integer recommendedSeq) {
		this.recommendedSeq = recommendedSeq;
	}

	public Integer getRecommendedTime() {
		return recommendedTime;
	}

	public void setRecommendedTime(Integer recommendedTime) {
		this.recommendedTime = recommendedTime;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public Integer getHitNum() {
		return hitNum;
	}

	public void setHitNum(Integer hitNum) {
		this.hitNum = hitNum;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Integer createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getFreeStartTime() {
		return freeStartTime;
	}

	public void setFreeStartTime(Integer freeStartTime) {
		this.freeStartTime = freeStartTime;
	}

	public Integer getFreeEndTime() {
		return freeEndTime;
	}

	public void setFreeEndTime(Integer freeEndTime) {
		this.freeEndTime = freeEndTime;
	}
}