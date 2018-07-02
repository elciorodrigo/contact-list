package com.bravi.contactList.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private TypeContactEntity type;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PersonEntity personEntity;

    private String value;

    public ContactEntity(TypeContactEntity type, String value, PersonEntity personEntity) {
        this.type = type;
        this.value = value;
        this.personEntity = personEntity;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    public ContactEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeContactEntity getType() {
        return type;
    }

    public void setType(TypeContactEntity type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
