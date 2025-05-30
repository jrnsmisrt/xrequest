package be.common.xrequest.domain.author;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    UUID id;
    @Column(name = "nickname")
    private String nickName;
    @Column(name = "family_name")
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "age")
    private Integer age;
    @Column(name = "place")
    @JoinColumn(name = "place", referencedColumnName = "id")
    private String place;

    public Author(String nickName, String name,
                  String surName, String email,
                  String phoneNumber,
                  Integer age, String place) {
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

    public UUID getId() {
        return id;
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

    public String getPlace() {
        return place;
    }

    public void setId(UUID id) {this.id = id;}

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


    public void setPlace(String place) {
        this.place = place;
    }
}
