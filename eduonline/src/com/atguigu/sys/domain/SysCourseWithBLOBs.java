package com.atguigu.sys.domain;

public class SysCourseWithBLOBs extends SysCourse {
    private String tags;

    private String about;

    private String teacherIds;

    private String goals;

    private String audiences;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }

    public String getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(String teacherIds) {
        this.teacherIds = teacherIds == null ? null : teacherIds.trim();
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals == null ? null : goals.trim();
    }

    public String getAudiences() {
        return audiences;
    }

    public void setAudiences(String audiences) {
        this.audiences = audiences == null ? null : audiences.trim();
    }
}