package com.dm.onerosterapi.model;

import javax.persistence.*;

@Entity
public class Org {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orgid")
    private String orgId;

    @Column(name = "sourcedid")
    private String sourcedId;

    @Column(name = "status")
    private String status;

    @Column(name = "datelastmodified")
    private String dateLastModified;

    @Column(name = "metadata")
    private String metadata;

    @Column(name = "name")
    private String name;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "type")
    private String type;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Org org = (Org) o;

        if (orgId != null ? !orgId.equals(org.orgId) : org.orgId != null) return false;
        if (sourcedId != null ? !sourcedId.equals(org.sourcedId) : org.sourcedId != null) return false;
        if (status != null ? !status.equals(org.status) : org.status != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(org.dateLastModified) : org.dateLastModified != null)
            return false;
        if (metadata != null ? !metadata.equals(org.metadata) : org.metadata != null) return false;
        if (name != null ? !name.equals(org.name) : org.name != null) return false;
        if (identifier != null ? !identifier.equals(org.identifier) : org.identifier != null) return false;
        return type != null ? type.equals(org.type) : org.type == null;
    }

    @Override
    public int hashCode() {
        int result = orgId != null ? orgId.hashCode() : 0;
        result = 31 * result + (sourcedId != null ? sourcedId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        result = 31 * result + (metadata != null ? metadata.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}

