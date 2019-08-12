package com.danny.sfgpetclinic.model;

import java.io.Serializable;


public class BaseEntity implements Serializable {

    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
