package com.service.ship.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingModel<T> {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    @CreatedBy
    protected T createBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastModifielDate;

    @LastModifiedBy
    protected T lastModifielBy;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public T getCreateBy() {
        return createBy;
    }

    public void setCreateBy(T createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifielDate() {
        return lastModifielDate;
    }

    public void setLastModifielDate(Date lastModifielDate) {
        this.lastModifielDate = lastModifielDate;
    }

    public T getLastModifielBy() {
        return lastModifielBy;
    }

    public void setLastModifielBy(T lastModifielBy) {
        this.lastModifielBy = lastModifielBy;
    }
}
