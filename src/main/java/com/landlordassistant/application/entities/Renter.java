package com.landlordassistant.application.entities;

import com.landlordassistant.application.embedded.Gender;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "renters")
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "middle_name")
    private String middleName;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Column(name = "start_renting")
    private LocalDate startRenting;

    public Renter() {
    }

    public Renter(String name, String middleName, String surname, Gender gender, LocalDate startRenting) {
        this.name = name;
        this.middleName = middleName;
        this.surname = surname;
        this.gender = gender;
        this.startRenting = startRenting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Renter renter = (Renter) o;

        if (id != renter.id) return false;
        if (!name.equals(renter.name)) return false;
        if (!middleName.equals(renter.middleName)) return false;
        if (!surname.equals(renter.surname)) return false;
        if (gender != renter.gender) return false;
        return startRenting.equals(renter.startRenting);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + startRenting.hashCode();
        return result;
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

    @Override
    public String toString() {
        return name + " " + surname + ", id: " + id + " ";
    }
}
