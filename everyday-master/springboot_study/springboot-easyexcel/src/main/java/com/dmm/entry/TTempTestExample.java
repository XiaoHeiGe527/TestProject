package com.dmm.entry;

import java.util.ArrayList;
import java.util.List;

public class TTempTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TTempTestExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andName1IsNull() {
            addCriterion("name1 is null");
            return (Criteria) this;
        }

        public Criteria andName1IsNotNull() {
            addCriterion("name1 is not null");
            return (Criteria) this;
        }

        public Criteria andName1EqualTo(String value) {
            addCriterion("name1 =", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotEqualTo(String value) {
            addCriterion("name1 <>", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThan(String value) {
            addCriterion("name1 >", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThanOrEqualTo(String value) {
            addCriterion("name1 >=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThan(String value) {
            addCriterion("name1 <", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThanOrEqualTo(String value) {
            addCriterion("name1 <=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Like(String value) {
            addCriterion("name1 like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotLike(String value) {
            addCriterion("name1 not like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1In(List<String> values) {
            addCriterion("name1 in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotIn(List<String> values) {
            addCriterion("name1 not in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Between(String value1, String value2) {
            addCriterion("name1 between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotBetween(String value1, String value2) {
            addCriterion("name1 not between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName2IsNull() {
            addCriterion("name2 is null");
            return (Criteria) this;
        }

        public Criteria andName2IsNotNull() {
            addCriterion("name2 is not null");
            return (Criteria) this;
        }

        public Criteria andName2EqualTo(String value) {
            addCriterion("name2 =", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotEqualTo(String value) {
            addCriterion("name2 <>", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThan(String value) {
            addCriterion("name2 >", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThanOrEqualTo(String value) {
            addCriterion("name2 >=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThan(String value) {
            addCriterion("name2 <", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThanOrEqualTo(String value) {
            addCriterion("name2 <=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Like(String value) {
            addCriterion("name2 like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotLike(String value) {
            addCriterion("name2 not like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2In(List<String> values) {
            addCriterion("name2 in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotIn(List<String> values) {
            addCriterion("name2 not in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Between(String value1, String value2) {
            addCriterion("name2 between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotBetween(String value1, String value2) {
            addCriterion("name2 not between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName3IsNull() {
            addCriterion("name3 is null");
            return (Criteria) this;
        }

        public Criteria andName3IsNotNull() {
            addCriterion("name3 is not null");
            return (Criteria) this;
        }

        public Criteria andName3EqualTo(String value) {
            addCriterion("name3 =", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotEqualTo(String value) {
            addCriterion("name3 <>", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3GreaterThan(String value) {
            addCriterion("name3 >", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3GreaterThanOrEqualTo(String value) {
            addCriterion("name3 >=", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3LessThan(String value) {
            addCriterion("name3 <", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3LessThanOrEqualTo(String value) {
            addCriterion("name3 <=", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3Like(String value) {
            addCriterion("name3 like", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotLike(String value) {
            addCriterion("name3 not like", value, "name3");
            return (Criteria) this;
        }

        public Criteria andName3In(List<String> values) {
            addCriterion("name3 in", values, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotIn(List<String> values) {
            addCriterion("name3 not in", values, "name3");
            return (Criteria) this;
        }

        public Criteria andName3Between(String value1, String value2) {
            addCriterion("name3 between", value1, value2, "name3");
            return (Criteria) this;
        }

        public Criteria andName3NotBetween(String value1, String value2) {
            addCriterion("name3 not between", value1, value2, "name3");
            return (Criteria) this;
        }

        public Criteria andName4IsNull() {
            addCriterion("name4 is null");
            return (Criteria) this;
        }

        public Criteria andName4IsNotNull() {
            addCriterion("name4 is not null");
            return (Criteria) this;
        }

        public Criteria andName4EqualTo(String value) {
            addCriterion("name4 =", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotEqualTo(String value) {
            addCriterion("name4 <>", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4GreaterThan(String value) {
            addCriterion("name4 >", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4GreaterThanOrEqualTo(String value) {
            addCriterion("name4 >=", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4LessThan(String value) {
            addCriterion("name4 <", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4LessThanOrEqualTo(String value) {
            addCriterion("name4 <=", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4Like(String value) {
            addCriterion("name4 like", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotLike(String value) {
            addCriterion("name4 not like", value, "name4");
            return (Criteria) this;
        }

        public Criteria andName4In(List<String> values) {
            addCriterion("name4 in", values, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotIn(List<String> values) {
            addCriterion("name4 not in", values, "name4");
            return (Criteria) this;
        }

        public Criteria andName4Between(String value1, String value2) {
            addCriterion("name4 between", value1, value2, "name4");
            return (Criteria) this;
        }

        public Criteria andName4NotBetween(String value1, String value2) {
            addCriterion("name4 not between", value1, value2, "name4");
            return (Criteria) this;
        }

        public Criteria andName5IsNull() {
            addCriterion("name5 is null");
            return (Criteria) this;
        }

        public Criteria andName5IsNotNull() {
            addCriterion("name5 is not null");
            return (Criteria) this;
        }

        public Criteria andName5EqualTo(String value) {
            addCriterion("name5 =", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotEqualTo(String value) {
            addCriterion("name5 <>", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5GreaterThan(String value) {
            addCriterion("name5 >", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5GreaterThanOrEqualTo(String value) {
            addCriterion("name5 >=", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5LessThan(String value) {
            addCriterion("name5 <", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5LessThanOrEqualTo(String value) {
            addCriterion("name5 <=", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5Like(String value) {
            addCriterion("name5 like", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotLike(String value) {
            addCriterion("name5 not like", value, "name5");
            return (Criteria) this;
        }

        public Criteria andName5In(List<String> values) {
            addCriterion("name5 in", values, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotIn(List<String> values) {
            addCriterion("name5 not in", values, "name5");
            return (Criteria) this;
        }

        public Criteria andName5Between(String value1, String value2) {
            addCriterion("name5 between", value1, value2, "name5");
            return (Criteria) this;
        }

        public Criteria andName5NotBetween(String value1, String value2) {
            addCriterion("name5 not between", value1, value2, "name5");
            return (Criteria) this;
        }

        public Criteria andName6IsNull() {
            addCriterion("name6 is null");
            return (Criteria) this;
        }

        public Criteria andName6IsNotNull() {
            addCriterion("name6 is not null");
            return (Criteria) this;
        }

        public Criteria andName6EqualTo(String value) {
            addCriterion("name6 =", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6NotEqualTo(String value) {
            addCriterion("name6 <>", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6GreaterThan(String value) {
            addCriterion("name6 >", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6GreaterThanOrEqualTo(String value) {
            addCriterion("name6 >=", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6LessThan(String value) {
            addCriterion("name6 <", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6LessThanOrEqualTo(String value) {
            addCriterion("name6 <=", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6Like(String value) {
            addCriterion("name6 like", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6NotLike(String value) {
            addCriterion("name6 not like", value, "name6");
            return (Criteria) this;
        }

        public Criteria andName6In(List<String> values) {
            addCriterion("name6 in", values, "name6");
            return (Criteria) this;
        }

        public Criteria andName6NotIn(List<String> values) {
            addCriterion("name6 not in", values, "name6");
            return (Criteria) this;
        }

        public Criteria andName6Between(String value1, String value2) {
            addCriterion("name6 between", value1, value2, "name6");
            return (Criteria) this;
        }

        public Criteria andName6NotBetween(String value1, String value2) {
            addCriterion("name6 not between", value1, value2, "name6");
            return (Criteria) this;
        }

        public Criteria andName7IsNull() {
            addCriterion("name7 is null");
            return (Criteria) this;
        }

        public Criteria andName7IsNotNull() {
            addCriterion("name7 is not null");
            return (Criteria) this;
        }

        public Criteria andName7EqualTo(String value) {
            addCriterion("name7 =", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7NotEqualTo(String value) {
            addCriterion("name7 <>", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7GreaterThan(String value) {
            addCriterion("name7 >", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7GreaterThanOrEqualTo(String value) {
            addCriterion("name7 >=", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7LessThan(String value) {
            addCriterion("name7 <", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7LessThanOrEqualTo(String value) {
            addCriterion("name7 <=", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7Like(String value) {
            addCriterion("name7 like", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7NotLike(String value) {
            addCriterion("name7 not like", value, "name7");
            return (Criteria) this;
        }

        public Criteria andName7In(List<String> values) {
            addCriterion("name7 in", values, "name7");
            return (Criteria) this;
        }

        public Criteria andName7NotIn(List<String> values) {
            addCriterion("name7 not in", values, "name7");
            return (Criteria) this;
        }

        public Criteria andName7Between(String value1, String value2) {
            addCriterion("name7 between", value1, value2, "name7");
            return (Criteria) this;
        }

        public Criteria andName7NotBetween(String value1, String value2) {
            addCriterion("name7 not between", value1, value2, "name7");
            return (Criteria) this;
        }

        public Criteria andName8IsNull() {
            addCriterion("name8 is null");
            return (Criteria) this;
        }

        public Criteria andName8IsNotNull() {
            addCriterion("name8 is not null");
            return (Criteria) this;
        }

        public Criteria andName8EqualTo(String value) {
            addCriterion("name8 =", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8NotEqualTo(String value) {
            addCriterion("name8 <>", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8GreaterThan(String value) {
            addCriterion("name8 >", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8GreaterThanOrEqualTo(String value) {
            addCriterion("name8 >=", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8LessThan(String value) {
            addCriterion("name8 <", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8LessThanOrEqualTo(String value) {
            addCriterion("name8 <=", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8Like(String value) {
            addCriterion("name8 like", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8NotLike(String value) {
            addCriterion("name8 not like", value, "name8");
            return (Criteria) this;
        }

        public Criteria andName8In(List<String> values) {
            addCriterion("name8 in", values, "name8");
            return (Criteria) this;
        }

        public Criteria andName8NotIn(List<String> values) {
            addCriterion("name8 not in", values, "name8");
            return (Criteria) this;
        }

        public Criteria andName8Between(String value1, String value2) {
            addCriterion("name8 between", value1, value2, "name8");
            return (Criteria) this;
        }

        public Criteria andName8NotBetween(String value1, String value2) {
            addCriterion("name8 not between", value1, value2, "name8");
            return (Criteria) this;
        }

        public Criteria andName9IsNull() {
            addCriterion("name9 is null");
            return (Criteria) this;
        }

        public Criteria andName9IsNotNull() {
            addCriterion("name9 is not null");
            return (Criteria) this;
        }

        public Criteria andName9EqualTo(String value) {
            addCriterion("name9 =", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9NotEqualTo(String value) {
            addCriterion("name9 <>", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9GreaterThan(String value) {
            addCriterion("name9 >", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9GreaterThanOrEqualTo(String value) {
            addCriterion("name9 >=", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9LessThan(String value) {
            addCriterion("name9 <", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9LessThanOrEqualTo(String value) {
            addCriterion("name9 <=", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9Like(String value) {
            addCriterion("name9 like", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9NotLike(String value) {
            addCriterion("name9 not like", value, "name9");
            return (Criteria) this;
        }

        public Criteria andName9In(List<String> values) {
            addCriterion("name9 in", values, "name9");
            return (Criteria) this;
        }

        public Criteria andName9NotIn(List<String> values) {
            addCriterion("name9 not in", values, "name9");
            return (Criteria) this;
        }

        public Criteria andName9Between(String value1, String value2) {
            addCriterion("name9 between", value1, value2, "name9");
            return (Criteria) this;
        }

        public Criteria andName9NotBetween(String value1, String value2) {
            addCriterion("name9 not between", value1, value2, "name9");
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