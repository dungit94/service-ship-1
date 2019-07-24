package com.service.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.service.ship.audit.Auditable;

@Entity
@Table(name = "demo")
@EntityListeners(AuditingEntityListener.class)
public class Demo extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(initialValue = 100,  name = "demo_generator",
            sequenceName = "demo_sequence")
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
