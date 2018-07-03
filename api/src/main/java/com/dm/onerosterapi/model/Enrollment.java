package com.dm.onerosterapi.model;

import javax.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "enrollment_Sequence")
    @SequenceGenerator(name = "enrollment_Sequence", sequenceName = "ENROLLMENT_SEQ")
    private String enrollmentId;

    @Column(name = "sourcedId")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "dateLastModified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "userId")
    private String userId;

    @Column(name = "classId")
    private String classId;

    @Column(name = "`primary`")
    private String primary;

    @Column(name = "beginDate")
    private String beginDate;

    @Column(name = "endDate")
    private String endDate;


    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollment that = (Enrollment) o;

        if (enrollmentId != null ? !enrollmentId.equals(that.enrollmentId) : that.enrollmentId != null) return false;
        if (sourcedId != null ? !sourcedId.equals(that.sourcedId) : that.sourcedId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(that.dateLastModified) : that.dateLastModified != null)
            return false;
        if (metadata != null ? !metadata.equals(that.metadata) : that.metadata != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (primary != null ? !primary.equals(that.primary) : that.primary != null) return false;
        if (beginDate != null ? !beginDate.equals(that.beginDate) : that.beginDate != null) return false;
        return endDate != null ? endDate.equals(that.endDate) : that.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = enrollmentId != null ? enrollmentId.hashCode() : 0;
        result = 31 * result + (sourcedId != null ? sourcedId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (primary != null ? primary.hashCode() : 0);
        result = 31 * result + (beginDate != null ? beginDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}
