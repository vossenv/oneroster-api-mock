package com.dm.onerosterapi.model;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;

    @Column(name = "sourcedId")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "dateLastModified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "grade")
    private String grade;

    @Column(name = "title")
    private String title;

    @Column(name = "schoolYear")
    private String schoolYear;

    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "subjects")
    private String subjects;

    @Column(name = "orgId")
    private String orgId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (sourcedId != null ? !sourcedId.equals(course.sourcedId) : course.sourcedId != null) return false;
        if (status != null ? !status.equals(course.status) : course.status != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(course.dateLastModified) : course.dateLastModified != null)
            return false;
        if (metadata != null ? !metadata.equals(course.metadata) : course.metadata != null) return false;
        if (grade != null ? !grade.equals(course.grade) : course.grade != null) return false;
        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        if (schoolYear != null ? !schoolYear.equals(course.schoolYear) : course.schoolYear != null) return false;
        if (courseCode != null ? !courseCode.equals(course.courseCode) : course.courseCode != null) return false;
        if (subjects != null ? !subjects.equals(course.subjects) : course.subjects != null) return false;
        return orgId != null ? orgId.equals(course.orgId) : course.orgId == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (sourcedId != null ? sourcedId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (schoolYear != null ? schoolYear.hashCode() : 0);
        result = 31 * result + (courseCode != null ? courseCode.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        return result;
    }
}
