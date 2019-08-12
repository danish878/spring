package com.serialization.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SerializedUser {

    @Id
    @GeneratedValue
    private Integer id;

    private byte[] serializedUser;

    public SerializedUser() {}

    public SerializedUser(byte[] serializedUser) {
        this.serializedUser = serializedUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getSerializedUser() {
        return serializedUser;
    }

    public void setSerializedUser(byte[] serializedUser) {
        this.serializedUser = serializedUser;
    }
}
