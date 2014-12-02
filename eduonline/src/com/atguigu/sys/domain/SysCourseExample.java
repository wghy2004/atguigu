package com.atguigu.sys.domain;

import java.util.ArrayList;
import java.util.List;

public class SysCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumIsNull() {
            addCriterion("maxStudentNum is null");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumIsNotNull() {
            addCriterion("maxStudentNum is not null");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumEqualTo(Integer value) {
            addCriterion("maxStudentNum =", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumNotEqualTo(Integer value) {
            addCriterion("maxStudentNum <>", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumGreaterThan(Integer value) {
            addCriterion("maxStudentNum >", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxStudentNum >=", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumLessThan(Integer value) {
            addCriterion("maxStudentNum <", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumLessThanOrEqualTo(Integer value) {
            addCriterion("maxStudentNum <=", value, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumIn(List<Integer> values) {
            addCriterion("maxStudentNum in", values, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumNotIn(List<Integer> values) {
            addCriterion("maxStudentNum not in", values, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumBetween(Integer value1, Integer value2) {
            addCriterion("maxStudentNum between", value1, value2, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andMaxStudentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("maxStudentNum not between", value1, value2, "maxStudentNum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andExpiryDayIsNull() {
            addCriterion("expiryDay is null");
            return (Criteria) this;
        }

        public Criteria andExpiryDayIsNotNull() {
            addCriterion("expiryDay is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryDayEqualTo(Integer value) {
            addCriterion("expiryDay =", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayNotEqualTo(Integer value) {
            addCriterion("expiryDay <>", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayGreaterThan(Integer value) {
            addCriterion("expiryDay >", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("expiryDay >=", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayLessThan(Integer value) {
            addCriterion("expiryDay <", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayLessThanOrEqualTo(Integer value) {
            addCriterion("expiryDay <=", value, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayIn(List<Integer> values) {
            addCriterion("expiryDay in", values, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayNotIn(List<Integer> values) {
            addCriterion("expiryDay not in", values, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayBetween(Integer value1, Integer value2) {
            addCriterion("expiryDay between", value1, value2, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andExpiryDayNotBetween(Integer value1, Integer value2) {
            addCriterion("expiryDay not between", value1, value2, "expiryDay");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeIsNull() {
            addCriterion("showStudentNumType is null");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeIsNotNull() {
            addCriterion("showStudentNumType is not null");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeEqualTo(String value) {
            addCriterion("showStudentNumType =", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeNotEqualTo(String value) {
            addCriterion("showStudentNumType <>", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeGreaterThan(String value) {
            addCriterion("showStudentNumType >", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeGreaterThanOrEqualTo(String value) {
            addCriterion("showStudentNumType >=", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeLessThan(String value) {
            addCriterion("showStudentNumType <", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeLessThanOrEqualTo(String value) {
            addCriterion("showStudentNumType <=", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeLike(String value) {
            addCriterion("showStudentNumType like", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeNotLike(String value) {
            addCriterion("showStudentNumType not like", value, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeIn(List<String> values) {
            addCriterion("showStudentNumType in", values, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeNotIn(List<String> values) {
            addCriterion("showStudentNumType not in", values, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeBetween(String value1, String value2) {
            addCriterion("showStudentNumType between", value1, value2, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andShowStudentNumTypeNotBetween(String value1, String value2) {
            addCriterion("showStudentNumType not between", value1, value2, "showStudentNumType");
            return (Criteria) this;
        }

        public Criteria andSerializeModeIsNull() {
            addCriterion("serializeMode is null");
            return (Criteria) this;
        }

        public Criteria andSerializeModeIsNotNull() {
            addCriterion("serializeMode is not null");
            return (Criteria) this;
        }

        public Criteria andSerializeModeEqualTo(String value) {
            addCriterion("serializeMode =", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeNotEqualTo(String value) {
            addCriterion("serializeMode <>", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeGreaterThan(String value) {
            addCriterion("serializeMode >", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeGreaterThanOrEqualTo(String value) {
            addCriterion("serializeMode >=", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeLessThan(String value) {
            addCriterion("serializeMode <", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeLessThanOrEqualTo(String value) {
            addCriterion("serializeMode <=", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeLike(String value) {
            addCriterion("serializeMode like", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeNotLike(String value) {
            addCriterion("serializeMode not like", value, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeIn(List<String> values) {
            addCriterion("serializeMode in", values, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeNotIn(List<String> values) {
            addCriterion("serializeMode not in", values, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeBetween(String value1, String value2) {
            addCriterion("serializeMode between", value1, value2, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andSerializeModeNotBetween(String value1, String value2) {
            addCriterion("serializeMode not between", value1, value2, "serializeMode");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(Float value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(Float value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(Float value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(Float value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(Float value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(Float value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<Float> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<Float> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(Float value1, Float value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(Float value1, Float value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andLessonNumIsNull() {
            addCriterion("lessonNum is null");
            return (Criteria) this;
        }

        public Criteria andLessonNumIsNotNull() {
            addCriterion("lessonNum is not null");
            return (Criteria) this;
        }

        public Criteria andLessonNumEqualTo(Integer value) {
            addCriterion("lessonNum =", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumNotEqualTo(Integer value) {
            addCriterion("lessonNum <>", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumGreaterThan(Integer value) {
            addCriterion("lessonNum >", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lessonNum >=", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumLessThan(Integer value) {
            addCriterion("lessonNum <", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumLessThanOrEqualTo(Integer value) {
            addCriterion("lessonNum <=", value, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumIn(List<Integer> values) {
            addCriterion("lessonNum in", values, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumNotIn(List<Integer> values) {
            addCriterion("lessonNum not in", values, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumBetween(Integer value1, Integer value2) {
            addCriterion("lessonNum between", value1, value2, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andLessonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("lessonNum not between", value1, value2, "lessonNum");
            return (Criteria) this;
        }

        public Criteria andGiveCreditIsNull() {
            addCriterion("giveCredit is null");
            return (Criteria) this;
        }

        public Criteria andGiveCreditIsNotNull() {
            addCriterion("giveCredit is not null");
            return (Criteria) this;
        }

        public Criteria andGiveCreditEqualTo(Integer value) {
            addCriterion("giveCredit =", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditNotEqualTo(Integer value) {
            addCriterion("giveCredit <>", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditGreaterThan(Integer value) {
            addCriterion("giveCredit >", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("giveCredit >=", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditLessThan(Integer value) {
            addCriterion("giveCredit <", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditLessThanOrEqualTo(Integer value) {
            addCriterion("giveCredit <=", value, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditIn(List<Integer> values) {
            addCriterion("giveCredit in", values, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditNotIn(List<Integer> values) {
            addCriterion("giveCredit not in", values, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditBetween(Integer value1, Integer value2) {
            addCriterion("giveCredit between", value1, value2, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andGiveCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("giveCredit not between", value1, value2, "giveCredit");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(Integer value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(Integer value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(Integer value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(Integer value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(Integer value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(Integer value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<Integer> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<Integer> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(Integer value1, Integer value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(Integer value1, Integer value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNumIsNull() {
            addCriterion("ratingNum is null");
            return (Criteria) this;
        }

        public Criteria andRatingNumIsNotNull() {
            addCriterion("ratingNum is not null");
            return (Criteria) this;
        }

        public Criteria andRatingNumEqualTo(Integer value) {
            addCriterion("ratingNum =", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumNotEqualTo(Integer value) {
            addCriterion("ratingNum <>", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumGreaterThan(Integer value) {
            addCriterion("ratingNum >", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ratingNum >=", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumLessThan(Integer value) {
            addCriterion("ratingNum <", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumLessThanOrEqualTo(Integer value) {
            addCriterion("ratingNum <=", value, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumIn(List<Integer> values) {
            addCriterion("ratingNum in", values, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumNotIn(List<Integer> values) {
            addCriterion("ratingNum not in", values, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumBetween(Integer value1, Integer value2) {
            addCriterion("ratingNum between", value1, value2, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andRatingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ratingNum not between", value1, value2, "ratingNum");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdIsNull() {
            addCriterion("vipLevelId is null");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdIsNotNull() {
            addCriterion("vipLevelId is not null");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdEqualTo(Integer value) {
            addCriterion("vipLevelId =", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdNotEqualTo(Integer value) {
            addCriterion("vipLevelId <>", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdGreaterThan(Integer value) {
            addCriterion("vipLevelId >", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vipLevelId >=", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdLessThan(Integer value) {
            addCriterion("vipLevelId <", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdLessThanOrEqualTo(Integer value) {
            addCriterion("vipLevelId <=", value, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdIn(List<Integer> values) {
            addCriterion("vipLevelId in", values, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdNotIn(List<Integer> values) {
            addCriterion("vipLevelId not in", values, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdBetween(Integer value1, Integer value2) {
            addCriterion("vipLevelId between", value1, value2, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andVipLevelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vipLevelId not between", value1, value2, "vipLevelId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("categoryId is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("categoryId is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("categoryId =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("categoryId <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("categoryId >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("categoryId >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("categoryId <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("categoryId <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("categoryId in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("categoryId not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("categoryId between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("categoryId not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSmallPictureIsNull() {
            addCriterion("smallPicture is null");
            return (Criteria) this;
        }

        public Criteria andSmallPictureIsNotNull() {
            addCriterion("smallPicture is not null");
            return (Criteria) this;
        }

        public Criteria andSmallPictureEqualTo(String value) {
            addCriterion("smallPicture =", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureNotEqualTo(String value) {
            addCriterion("smallPicture <>", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureGreaterThan(String value) {
            addCriterion("smallPicture >", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureGreaterThanOrEqualTo(String value) {
            addCriterion("smallPicture >=", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureLessThan(String value) {
            addCriterion("smallPicture <", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureLessThanOrEqualTo(String value) {
            addCriterion("smallPicture <=", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureLike(String value) {
            addCriterion("smallPicture like", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureNotLike(String value) {
            addCriterion("smallPicture not like", value, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureIn(List<String> values) {
            addCriterion("smallPicture in", values, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureNotIn(List<String> values) {
            addCriterion("smallPicture not in", values, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureBetween(String value1, String value2) {
            addCriterion("smallPicture between", value1, value2, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andSmallPictureNotBetween(String value1, String value2) {
            addCriterion("smallPicture not between", value1, value2, "smallPicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureIsNull() {
            addCriterion("middlePicture is null");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureIsNotNull() {
            addCriterion("middlePicture is not null");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureEqualTo(String value) {
            addCriterion("middlePicture =", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureNotEqualTo(String value) {
            addCriterion("middlePicture <>", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureGreaterThan(String value) {
            addCriterion("middlePicture >", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureGreaterThanOrEqualTo(String value) {
            addCriterion("middlePicture >=", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureLessThan(String value) {
            addCriterion("middlePicture <", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureLessThanOrEqualTo(String value) {
            addCriterion("middlePicture <=", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureLike(String value) {
            addCriterion("middlePicture like", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureNotLike(String value) {
            addCriterion("middlePicture not like", value, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureIn(List<String> values) {
            addCriterion("middlePicture in", values, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureNotIn(List<String> values) {
            addCriterion("middlePicture not in", values, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureBetween(String value1, String value2) {
            addCriterion("middlePicture between", value1, value2, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andMiddlePictureNotBetween(String value1, String value2) {
            addCriterion("middlePicture not between", value1, value2, "middlePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureIsNull() {
            addCriterion("largePicture is null");
            return (Criteria) this;
        }

        public Criteria andLargePictureIsNotNull() {
            addCriterion("largePicture is not null");
            return (Criteria) this;
        }

        public Criteria andLargePictureEqualTo(String value) {
            addCriterion("largePicture =", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureNotEqualTo(String value) {
            addCriterion("largePicture <>", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureGreaterThan(String value) {
            addCriterion("largePicture >", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureGreaterThanOrEqualTo(String value) {
            addCriterion("largePicture >=", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureLessThan(String value) {
            addCriterion("largePicture <", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureLessThanOrEqualTo(String value) {
            addCriterion("largePicture <=", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureLike(String value) {
            addCriterion("largePicture like", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureNotLike(String value) {
            addCriterion("largePicture not like", value, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureIn(List<String> values) {
            addCriterion("largePicture in", values, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureNotIn(List<String> values) {
            addCriterion("largePicture not in", values, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureBetween(String value1, String value2) {
            addCriterion("largePicture between", value1, value2, "largePicture");
            return (Criteria) this;
        }

        public Criteria andLargePictureNotBetween(String value1, String value2) {
            addCriterion("largePicture not between", value1, value2, "largePicture");
            return (Criteria) this;
        }

        public Criteria andRecommendedIsNull() {
            addCriterion("recommended is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedIsNotNull() {
            addCriterion("recommended is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedEqualTo(Byte value) {
            addCriterion("recommended =", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotEqualTo(Byte value) {
            addCriterion("recommended <>", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThan(Byte value) {
            addCriterion("recommended >", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedGreaterThanOrEqualTo(Byte value) {
            addCriterion("recommended >=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThan(Byte value) {
            addCriterion("recommended <", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedLessThanOrEqualTo(Byte value) {
            addCriterion("recommended <=", value, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedIn(List<Byte> values) {
            addCriterion("recommended in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotIn(List<Byte> values) {
            addCriterion("recommended not in", values, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedBetween(Byte value1, Byte value2) {
            addCriterion("recommended between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedNotBetween(Byte value1, Byte value2) {
            addCriterion("recommended not between", value1, value2, "recommended");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqIsNull() {
            addCriterion("recommendedSeq is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqIsNotNull() {
            addCriterion("recommendedSeq is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqEqualTo(Integer value) {
            addCriterion("recommendedSeq =", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqNotEqualTo(Integer value) {
            addCriterion("recommendedSeq <>", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqGreaterThan(Integer value) {
            addCriterion("recommendedSeq >", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommendedSeq >=", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqLessThan(Integer value) {
            addCriterion("recommendedSeq <", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqLessThanOrEqualTo(Integer value) {
            addCriterion("recommendedSeq <=", value, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqIn(List<Integer> values) {
            addCriterion("recommendedSeq in", values, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqNotIn(List<Integer> values) {
            addCriterion("recommendedSeq not in", values, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqBetween(Integer value1, Integer value2) {
            addCriterion("recommendedSeq between", value1, value2, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("recommendedSeq not between", value1, value2, "recommendedSeq");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeIsNull() {
            addCriterion("recommendedTime is null");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeIsNotNull() {
            addCriterion("recommendedTime is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeEqualTo(Integer value) {
            addCriterion("recommendedTime =", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeNotEqualTo(Integer value) {
            addCriterion("recommendedTime <>", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeGreaterThan(Integer value) {
            addCriterion("recommendedTime >", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommendedTime >=", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeLessThan(Integer value) {
            addCriterion("recommendedTime <", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeLessThanOrEqualTo(Integer value) {
            addCriterion("recommendedTime <=", value, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeIn(List<Integer> values) {
            addCriterion("recommendedTime in", values, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeNotIn(List<Integer> values) {
            addCriterion("recommendedTime not in", values, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeBetween(Integer value1, Integer value2) {
            addCriterion("recommendedTime between", value1, value2, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andRecommendedTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("recommendedTime not between", value1, value2, "recommendedTime");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNull() {
            addCriterion("locationId is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("locationId is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Integer value) {
            addCriterion("locationId =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Integer value) {
            addCriterion("locationId <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Integer value) {
            addCriterion("locationId >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("locationId >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Integer value) {
            addCriterion("locationId <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Integer value) {
            addCriterion("locationId <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Integer> values) {
            addCriterion("locationId in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Integer> values) {
            addCriterion("locationId not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Integer value1, Integer value2) {
            addCriterion("locationId between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("locationId not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNull() {
            addCriterion("studentNum is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumIsNotNull() {
            addCriterion("studentNum is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumEqualTo(Integer value) {
            addCriterion("studentNum =", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotEqualTo(Integer value) {
            addCriterion("studentNum <>", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThan(Integer value) {
            addCriterion("studentNum >", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentNum >=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThan(Integer value) {
            addCriterion("studentNum <", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumLessThanOrEqualTo(Integer value) {
            addCriterion("studentNum <=", value, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumIn(List<Integer> values) {
            addCriterion("studentNum in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotIn(List<Integer> values) {
            addCriterion("studentNum not in", values, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumBetween(Integer value1, Integer value2) {
            addCriterion("studentNum between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andStudentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("studentNum not between", value1, value2, "studentNum");
            return (Criteria) this;
        }

        public Criteria andHitNumIsNull() {
            addCriterion("hitNum is null");
            return (Criteria) this;
        }

        public Criteria andHitNumIsNotNull() {
            addCriterion("hitNum is not null");
            return (Criteria) this;
        }

        public Criteria andHitNumEqualTo(Integer value) {
            addCriterion("hitNum =", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotEqualTo(Integer value) {
            addCriterion("hitNum <>", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumGreaterThan(Integer value) {
            addCriterion("hitNum >", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("hitNum >=", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumLessThan(Integer value) {
            addCriterion("hitNum <", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumLessThanOrEqualTo(Integer value) {
            addCriterion("hitNum <=", value, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumIn(List<Integer> values) {
            addCriterion("hitNum in", values, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotIn(List<Integer> values) {
            addCriterion("hitNum not in", values, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumBetween(Integer value1, Integer value2) {
            addCriterion("hitNum between", value1, value2, "hitNum");
            return (Criteria) this;
        }

        public Criteria andHitNumNotBetween(Integer value1, Integer value2) {
            addCriterion("hitNum not between", value1, value2, "hitNum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("createdTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("createdTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Integer value) {
            addCriterion("createdTime =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Integer value) {
            addCriterion("createdTime <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Integer value) {
            addCriterion("createdTime >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("createdTime >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Integer value) {
            addCriterion("createdTime <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Integer value) {
            addCriterion("createdTime <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Integer> values) {
            addCriterion("createdTime in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Integer> values) {
            addCriterion("createdTime not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Integer value1, Integer value2) {
            addCriterion("createdTime between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("createdTime not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeIsNull() {
            addCriterion("freeStartTime is null");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeIsNotNull() {
            addCriterion("freeStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeEqualTo(Integer value) {
            addCriterion("freeStartTime =", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeNotEqualTo(Integer value) {
            addCriterion("freeStartTime <>", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeGreaterThan(Integer value) {
            addCriterion("freeStartTime >", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeStartTime >=", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeLessThan(Integer value) {
            addCriterion("freeStartTime <", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("freeStartTime <=", value, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeIn(List<Integer> values) {
            addCriterion("freeStartTime in", values, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeNotIn(List<Integer> values) {
            addCriterion("freeStartTime not in", values, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("freeStartTime between", value1, value2, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("freeStartTime not between", value1, value2, "freeStartTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeIsNull() {
            addCriterion("freeEndTime is null");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeIsNotNull() {
            addCriterion("freeEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeEqualTo(Integer value) {
            addCriterion("freeEndTime =", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeNotEqualTo(Integer value) {
            addCriterion("freeEndTime <>", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeGreaterThan(Integer value) {
            addCriterion("freeEndTime >", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeEndTime >=", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeLessThan(Integer value) {
            addCriterion("freeEndTime <", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("freeEndTime <=", value, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeIn(List<Integer> values) {
            addCriterion("freeEndTime in", values, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeNotIn(List<Integer> values) {
            addCriterion("freeEndTime not in", values, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("freeEndTime between", value1, value2, "freeEndTime");
            return (Criteria) this;
        }

        public Criteria andFreeEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("freeEndTime not between", value1, value2, "freeEndTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}