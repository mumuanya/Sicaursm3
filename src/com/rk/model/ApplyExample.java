package com.rk.model;

import java.util.ArrayList;
import java.util.List;

public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeIsNull() {
            addCriterion("borrowtype is null");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeIsNotNull() {
            addCriterion("borrowtype is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeEqualTo(Integer value) {
            addCriterion("borrowtype =", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeNotEqualTo(Integer value) {
            addCriterion("borrowtype <>", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeGreaterThan(Integer value) {
            addCriterion("borrowtype >", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowtype >=", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeLessThan(Integer value) {
            addCriterion("borrowtype <", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeLessThanOrEqualTo(Integer value) {
            addCriterion("borrowtype <=", value, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeIn(List<Integer> values) {
            addCriterion("borrowtype in", values, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeNotIn(List<Integer> values) {
            addCriterion("borrowtype not in", values, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeBetween(Integer value1, Integer value2) {
            addCriterion("borrowtype between", value1, value2, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andBorrowtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowtype not between", value1, value2, "borrowtype");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonIsNull() {
            addCriterion("borrowreason is null");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonIsNotNull() {
            addCriterion("borrowreason is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonEqualTo(String value) {
            addCriterion("borrowreason =", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonNotEqualTo(String value) {
            addCriterion("borrowreason <>", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonGreaterThan(String value) {
            addCriterion("borrowreason >", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonGreaterThanOrEqualTo(String value) {
            addCriterion("borrowreason >=", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonLessThan(String value) {
            addCriterion("borrowreason <", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonLessThanOrEqualTo(String value) {
            addCriterion("borrowreason <=", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonLike(String value) {
            addCriterion("borrowreason like", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonNotLike(String value) {
            addCriterion("borrowreason not like", value, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonIn(List<String> values) {
            addCriterion("borrowreason in", values, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonNotIn(List<String> values) {
            addCriterion("borrowreason not in", values, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonBetween(String value1, String value2) {
            addCriterion("borrowreason between", value1, value2, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowreasonNotBetween(String value1, String value2) {
            addCriterion("borrowreason not between", value1, value2, "borrowreason");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIsNull() {
            addCriterion("borrowtime is null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIsNotNull() {
            addCriterion("borrowtime is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeEqualTo(Integer value) {
            addCriterion("borrowtime =", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotEqualTo(Integer value) {
            addCriterion("borrowtime <>", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeGreaterThan(Integer value) {
            addCriterion("borrowtime >", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowtime >=", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeLessThan(Integer value) {
            addCriterion("borrowtime <", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeLessThanOrEqualTo(Integer value) {
            addCriterion("borrowtime <=", value, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeIn(List<Integer> values) {
            addCriterion("borrowtime in", values, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotIn(List<Integer> values) {
            addCriterion("borrowtime not in", values, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeBetween(Integer value1, Integer value2) {
            addCriterion("borrowtime between", value1, value2, "borrowtime");
            return (Criteria) this;
        }

        public Criteria andBorrowtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowtime not between", value1, value2, "borrowtime");
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