package be.common.xrequest.domain.author;

import be.common.xrequest.domain.place.Place;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    UUID id;
    private String nickName;
    private String name;
    private String surName;
    private String email;
    private String phoneNumber;
    private Integer age;
    @OneToOne
    private Place place;

    public Author(String nickName, String name,
                  String surName, String email,
                  String phoneNumber,
                  Integer age, Place place) {
        this.nickName = nickName;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.place = place;
    }

    public Author() {
    }

    public String getNickName() {
        return nickName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public Place getPlace() {
        return place;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setSurName(String surName) {
        this.surName = surName;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public void setPlace(Place place) {
        this.place = place;
    }
}
