package com.service.Query;

import javax.persistence.*;

@Entity
@Table(name="query")
public class QueryRec {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusEnum status;

    @Column(name="description")
    private String description;

    public QueryRec () {
    }

    public QueryRec(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
