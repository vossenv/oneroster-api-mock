package com.dm.enrollment.enrollmentgenerator.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String userId;
    private String grades;
    private String role;
    private String orgId;

    private Map<String,Boolean> fallMap = new HashMap<>();
    private Map<String,Boolean> springMap = new HashMap<>();
    private List<Enrollment> enrollmentList = new ArrayList<>();

    public User() {

        this.fallMap.put("Algebra", true);
        this.fallMap.put("Physics", true);
        this.fallMap.put("Art", true);
        this.fallMap.put("Biology", true);
        this.fallMap.put("Geometry", true);
        this.fallMap.put("History", true);
        this.fallMap.put("Geography", true);
        this.springMap.putAll(fallMap);

    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Map<String, Boolean> getFallMap() {
        return fallMap;
    }

    public void setFallMap(Map<String, Boolean> fallMap) {
        this.fallMap = fallMap;
    }

    public Map<String, Boolean> getSpringMap() {
        return springMap;
    }

    public void setSpringMap(Map<String, Boolean> springMap) {
        this.springMap = springMap;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }
}
