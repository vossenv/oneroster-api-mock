package com.dm.onerosterapi.model;

import javax.persistence.*;

@Entity
public class ClassOfCourse {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "class_Sequence")
    @SequenceGenerator(name = "class_Sequence", sequenceName = "CLASS_SEQ")
    private String classId;

    @Column(name = "sourcedId")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "dateLastModified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "term")
    private String term;

    @Column(name = "classCode")
    private String classCode;

    @Column(name = "classType")
    private String classType;

    @Column(name = "location")
    private String location;

    @Column(name = "courseId")
    private String courseId;

    @Column(name = "orgId")
    private String orgId;

    @Column(name = "periods")
    private String periods;


    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassOfCourse that = (ClassOfCourse) o;

        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (sourcedId != null ? !sourcedId.equals(that.sourcedId) : that.sourcedId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(that.dateLastModified) : that.dateLastModified != null)
            return false;
        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;
        if (classCode != null ? !classCode.equals(that.classCode) : that.classCode != null) return false;
        if (classType != null ? !classType.equals(that.classType) : that.classType != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        return periods != null ? periods.equals(that.periods) : that.periods == null;
    }

    @Override
    public int hashCode() {
        int result = classId != null ? classId.hashCode() : 0;
        result = 31 * result + (sourcedId != null ? sourcedId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (classCode != null ? classCode.hashCode() : 0);
        result = 31 * result + (classType != null ? classType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (periods != null ? periods.hashCode() : 0);
        return result;
    }
}
