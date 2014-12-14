package com.atguigu.sys.domain;

import java.sql.Timestamp;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysCourseLesson implements Identifiable {

	private Long id;

	private Long courseId;

	private Long chapterId;

	private Integer number;

	private Integer seq;

	private Byte free;

	private String status;

	private String title;

	private String type;

	private Integer giveCredit;

	private Integer requireCredit;

	private Integer mediaId;

	private String mediaSource;

	private String mediaName;

	private Integer length;

	private Integer materialNum;

	private Integer quizNum;

	private Integer learnedNum;

	private Integer viewedNum;

	private Integer startTime;

	private Integer endTime;

	private Integer memberNum;

	private String replayStatus;

	private Long userId;

	private Timestamp createdTime;

	private String summary;

	private String tags;

	private String content;

	private String mediaUri;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getMediaUri() {
		return mediaUri;
	}

	public void setMediaUri(String mediaUri) {
		this.mediaUri = mediaUri == null ? null : mediaUri.trim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Byte getFree() {
		return free;
	}

	public void setFree(Byte free) {
		this.free = free;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Integer getGiveCredit() {
		return giveCredit;
	}

	public void setGiveCredit(Integer giveCredit) {
		this.giveCredit = giveCredit;
	}

	public Integer getRequireCredit() {
		return requireCredit;
	}

	public void setRequireCredit(Integer requireCredit) {
		this.requireCredit = requireCredit;
	}

	public Integer getMediaId() {
		return mediaId;
	}

	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaSource() {
		return mediaSource;
	}

	public void setMediaSource(String mediaSource) {
		this.mediaSource = mediaSource == null ? null : mediaSource.trim();
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName == null ? null : mediaName.trim();
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getMaterialNum() {
		return materialNum;
	}

	public void setMaterialNum(Integer materialNum) {
		this.materialNum = materialNum;
	}

	public Integer getQuizNum() {
		return quizNum;
	}

	public void setQuizNum(Integer quizNum) {
		this.quizNum = quizNum;
	}

	public Integer getLearnedNum() {
		return learnedNum;
	}

	public void setLearnedNum(Integer learnedNum) {
		this.learnedNum = learnedNum;
	}

	public Integer getViewedNum() {
		return viewedNum;
	}

	public void setViewedNum(Integer viewedNum) {
		this.viewedNum = viewedNum;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public String getReplayStatus() {
		return replayStatus;
	}

	public void setReplayStatus(String replayStatus) {
		this.replayStatus = replayStatus == null ? null : replayStatus.trim();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
}