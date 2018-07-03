package com.dm.onerosterapi.model;


import javax.persistence.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private String userId;

    @Column(name = "sourcedId")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "dateLastModified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "enabledUser")
    private String enabledUser;

    @Column(name = "userIds")
    private String userIds;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "orgId")
    private String orgId;

    @Column(name = "givenName")
    private String givenName;

    @Column(name = "familyName")
    private String familyName;

    @Column(name = "middleName")
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
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
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
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
        return result;
    }
}

