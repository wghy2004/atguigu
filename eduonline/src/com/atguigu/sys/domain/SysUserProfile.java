package com.atguigu.sys.domain;

import java.sql.Date;

import com.atguigu.frame.core.dao.domain.Identifiable;

public class SysUserProfile implements Identifiable {
	private Long id;
	private String truename;
	private String idcard;
	private String gender; // enum('male','female','secret')
	private String iam;
	private Date birthday;
	private String city;
	private String mobile;
	private String qq;
	private String signature;
	private String about;
	private String company;
	private String job;
	private String school;
	private String clazz;
	private String weibo;
	private String weixin;
	private String site;
	private Integer intField1;
	private Integer intField2;
	private Integer intField3;
	private Integer intField4;
	private Integer intField5;
	private Date dateField1;
	private Date dateField2;
	private Date dateField3;
	private Date dateField4;
	private Date dateField5;
	private Long floatField1;
	private Long floatField2;
	private Long floatField3;
	private Long floatField4;
	private Long floatField5;
	private String varcharField1;
	private String varcharField2;
	private String varcharField3;
	private String varcharField4;
	private String varcharField5;
	private String varcharField6;
	private String varcharField7;
	private String varcharField8;
	private String varcharField9;
	private String varcharField10;
	private String textField1;
	private String textField2;
	private String textField3;
	private String textField4;
	private String textField5;
	private String textField6;
	private String textField7;
	private String textField8;
	private String textField9;
	private String textField10;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIam() {
		return iam;
	}
	public void setIam(String iam) {
		this.iam = iam;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Integer getIntField1() {
		return intField1;
	}
	public void setIntField1(Integer intField1) {
		this.intField1 = intField1;
	}
	public Integer getIntField2() {
		return intField2;
	}
	public void setIntField2(Integer intField2) {
		this.intField2 = intField2;
	}
	public Integer getIntField3() {
		return intField3;
	}
	public void setIntField3(Integer intField3) {
		this.intField3 = intField3;
	}
	public Integer getIntField4() {
		return intField4;
	}
	public void setIntField4(Integer intField4) {
		this.intField4 = intField4;
	}
	public Integer getIntField5() {
		return intField5;
	}
	public void setIntField5(Integer intField5) {
		this.intField5 = intField5;
	}
	public Date getDateField1() {
		return dateField1;
	}
	public void setDateField1(Date dateField1) {
		this.dateField1 = dateField1;
	}
	public Date getDateField2() {
		return dateField2;
	}
	public void setDateField2(Date dateField2) {
		this.dateField2 = dateField2;
	}
	public Date getDateField3() {
		return dateField3;
	}
	public void setDateField3(Date dateField3) {
		this.dateField3 = dateField3;
	}
	public Date getDateField4() {
		return dateField4;
	}
	public void setDateField4(Date dateField4) {
		this.dateField4 = dateField4;
	}
	public Date getDateField5() {
		return dateField5;
	}
	public void setDateField5(Date dateField5) {
		this.dateField5 = dateField5;
	}
	public Long getFloatField1() {
		return floatField1;
	}
	public void setFloatField1(Long floatField1) {
		this.floatField1 = floatField1;
	}
	public Long getFloatField2() {
		return floatField2;
	}
	public void setFloatField2(Long floatField2) {
		this.floatField2 = floatField2;
	}
	public Long getFloatField3() {
		return floatField3;
	}
	public void setFloatField3(Long floatField3) {
		this.floatField3 = floatField3;
	}
	public Long getFloatField4() {
		return floatField4;
	}
	public void setFloatField4(Long floatField4) {
		this.floatField4 = floatField4;
	}
	public Long getFloatField5() {
		return floatField5;
	}
	public void setFloatField5(Long floatField5) {
		this.floatField5 = floatField5;
	}
	public String getVarcharField1() {
		return varcharField1;
	}
	public void setVarcharField1(String varcharField1) {
		this.varcharField1 = varcharField1;
	}
	public String getVarcharField2() {
		return varcharField2;
	}
	public void setVarcharField2(String varcharField2) {
		this.varcharField2 = varcharField2;
	}
	public String getVarcharField3() {
		return varcharField3;
	}
	public void setVarcharField3(String varcharField3) {
		this.varcharField3 = varcharField3;
	}
	public String getVarcharField4() {
		return varcharField4;
	}
	public void setVarcharField4(String varcharField4) {
		this.varcharField4 = varcharField4;
	}
	public String getVarcharField5() {
		return varcharField5;
	}
	public void setVarcharField5(String varcharField5) {
		this.varcharField5 = varcharField5;
	}
	public String getVarcharField6() {
		return varcharField6;
	}
	public void setVarcharField6(String varcharField6) {
		this.varcharField6 = varcharField6;
	}
	public String getVarcharField7() {
		return varcharField7;
	}
	public void setVarcharField7(String varcharField7) {
		this.varcharField7 = varcharField7;
	}
	public String getVarcharField8() {
		return varcharField8;
	}
	public void setVarcharField8(String varcharField8) {
		this.varcharField8 = varcharField8;
	}
	public String getVarcharField9() {
		return varcharField9;
	}
	public void setVarcharField9(String varcharField9) {
		this.varcharField9 = varcharField9;
	}
	public String getVarcharField10() {
		return varcharField10;
	}
	public void setVarcharField10(String varcharField10) {
		this.varcharField10 = varcharField10;
	}
	public String getTextField1() {
		return textField1;
	}
	public void setTextField1(String textField1) {
		this.textField1 = textField1;
	}
	public String getTextField2() {
		return textField2;
	}
	public void setTextField2(String textField2) {
		this.textField2 = textField2;
	}
	public String getTextField3() {
		return textField3;
	}
	public void setTextField3(String textField3) {
		this.textField3 = textField3;
	}
	public String getTextField4() {
		return textField4;
	}
	public void setTextField4(String textField4) {
		this.textField4 = textField4;
	}
	public String getTextField5() {
		return textField5;
	}
	public void setTextField5(String textField5) {
		this.textField5 = textField5;
	}
	public String getTextField6() {
		return textField6;
	}
	public void setTextField6(String textField6) {
		this.textField6 = textField6;
	}
	public String getTextField7() {
		return textField7;
	}
	public void setTextField7(String textField7) {
		this.textField7 = textField7;
	}
	public String getTextField8() {
		return textField8;
	}
	public void setTextField8(String textField8) {
		this.textField8 = textField8;
	}
	public String getTextField9() {
		return textField9;
	}
	public void setTextField9(String textField9) {
		this.textField9 = textField9;
	}
	public String getTextField10() {
		return textField10;
	}
	public void setTextField10(String textField10) {
		this.textField10 = textField10;
	}
	
}
