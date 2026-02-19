package com.tinder.books.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_USER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false,length = 80)
    private String firstName;

    @Column(name = "first_name",nullable = false,length = 80)
    private String lastName;

    @Column(nullable = false,length = 200)
    private String anddress;

    @Column(nullable = false,length = 10)
    private String gender;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAnddress() {
        return anddress;
    }

    public void setAnddress(String anddress) {
        this.anddress = anddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(firstName, userModel.firstName) && Objects.equals(lastName, userModel.lastName) && Objects.equals(anddress, userModel.anddress) && Objects.equals(gender, userModel.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, anddress, gender);
    }
}
