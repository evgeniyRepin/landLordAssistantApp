package com.landlordassistant.application.api;

import com.landlordassistant.application.constants.Gender;
import com.landlordassistant.application.entities.Renter;

import java.time.LocalDate;

public class RenterInfo {
    private long id;
    private String name;
    private String middleName;
    private String surname;
    private Gender gender;
    private LocalDate startRenting;

    public RenterInfo(long id, String name, String middleName, String surname, Gender gender, LocalDate startRenting) {
        this.id = id;
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.gender = gender;
        this.startRenting = startRenting;
    }

    public RenterInfo(Renter renter) {
        id = renter.getId();
        name = renter.getName();
        middleName = renter.getMiddleName();
        surname = renter.getSurname();
        gender = renter.getGender();
        startRenting = renter.getStartRenting();
    }

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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getStartRenting() {
        return startRenting;
    }

    public void setStartRenting(LocalDate startRenting) {
        this.startRenting = startRenting;
    }
}
