package be.common.xrequest.domain.author.dto;

public class AuthorDto {
    private String id;
    private String nickName;
    private String name;
    private String surName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String place;

    public String getId() {
        return id;
    }

    public AuthorDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public AuthorDto setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurName() {
        return surName;
    }

    public AuthorDto setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AuthorDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AuthorDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public AuthorDto setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public AuthorDto setPlace(String place) {
        this.place = place;
        return this;
    }
}
