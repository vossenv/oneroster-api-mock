package com.dm.onerosterapi.model;


import sun.nio.cs.US_ASCII;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userId;

    @Column(name = "sourcedid")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "datelastmodified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "enableduser")
    private String enabledUser;

    @Column(name = "userids")
    private String userIds;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "orgid")
    private String orgId;

    @Column(name = "givenname")
    private String givenName;

    @Column(name = "familyname")
    private String familyName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private String role;

    @Column(name = "grades")
    private String grades;

    @Column(name = "type")
    private String type;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Enrollment> enrollmentList;

    @Transient
    private List<ClassOfCourse> classList = new ArrayList<>();

    public List<ClassOfCourse> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassOfCourse> classList) {
        this.classList = classList;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSourcedId() {
        return sourcedId;
    }

    public void setSourcedId(String sourcedId) {
        this.sourcedId = sourcedId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(String dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getEnabledUser() {
        return enabledUser;
    }

    public void setEnabledUser(String enabledUser) {
        this.enabledUser = enabledUser;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMidleName() {
        return middleName;
    }

    public void setMidleName(String midleName) {
        this.middleName = midleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (sourcedId != null ? !sourcedId.equals(user.sourcedId) : user.sourcedId != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(user.dateLastModified) : user.dateLastModified != null)
            return false;
        if (metadata != null ? !metadata.equals(user.metadata) : user.metadata != null) return false;
        if (enabledUser != null ? !enabledUser.equals(user.enabledUser) : user.enabledUser != null) return false;
        if (userIds != null ? !userIds.equals(user.userIds) : user.userIds != null) return false;
        if (identifier != null ? !identifier.equals(user.identifier) : user.identifier != null) return false;
        if (orgId != null ? !orgId.equals(user.orgId) : user.orgId != null) return false;
        if (givenName != null ? !givenName.equals(user.givenName) : user.givenName != null) return false;
        if (familyName != null ? !familyName.equals(user.familyName) : user.familyName != null) return false;
        if (middleName != null ? !middleName.equals(user.middleName) : user.middleName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (grades != null ? !grades.equals(user.grades) : user.grades != null) return false;
        if (type != null ? !type.equals(user.type) : user.type != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (enrollmentList != null ? !enrollmentList.equals(user.enrollmentList) : user.enrollmentList != null)
            return false;
        return classList != null ? classList.equals(user.classList) : user.classList == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (sourcedId != null ? sourcedId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (enabledUser != null ? enabledUser.hashCode() : 0);
        result = 31 * result + (userIds != null ? userIds.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (givenName != null ? givenName.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (grades != null ? grades.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (enrollmentList != null ? enrollmentList.hashCode() : 0);
        result = 31 * result + (classList != null ? classList.hashCode() : 0);
        return result;
    }
}

