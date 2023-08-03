package be.common.xrequest.domain.author;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class AuthorTest {
    Author mockAuthor;

    @BeforeEach
    void setUp() {
        this.mockAuthor = new Author(
                "mocknickname",
                "mockname",
                "mocksurname",
                "mockemail",
                "mockphone",
                30,
                "1"
        );
    }

    @AfterEach
    void tearDown() {
        this.mockAuthor = null;
    }

    @Test
    void getId() {
        UUID random = UUID.randomUUID();
        this.mockAuthor.setId(random);
        Assertions.assertEquals(this.mockAuthor.getId(), random);
    }

    @Test
    void getNickName() {
        Assertions.assertEquals(this.mockAuthor.getNickName(), "mocknickname");
    }

    @Test
    void getName() {
        Assertions.assertEquals(this.mockAuthor.getName(), "mockname");
    }

    @Test
    void getSurName() {
        Assertions.assertEquals(this.mockAuthor.getSurName(), "mocksurname");
    }

    @Test
    void getEmail() {
        Assertions.assertEquals(this.mockAuthor.getEmail(), "mockemail");
    }

    @Test
    void getPhoneNumber() {
        Assertions.assertEquals(this.mockAuthor.getPhoneNumber(), "mockphone");
    }

    @Test
    void getAge() {
        Assertions.assertEquals(this.mockAuthor.getAge(), 30);
    }

    @Test
    void getPlace() {
        Assertions.assertEquals(this.mockAuthor.getPlace(), "1");
    }

    @Test
    void setNickName() {
        this.mockAuthor.setNickName("newnickname");
        Assertions.assertEquals(this.mockAuthor.getNickName(), "newnickname");
    }

    @Test
    void setName() {
        this.mockAuthor.setName("newname");
        Assertions.assertEquals(this.mockAuthor.getName(), "newname");
    }

    @Test
    void setSurName() {
        this.mockAuthor.setSurName("newsurname");
        Assertions.assertEquals(this.mockAuthor.getSurName(), "newsurname");
    }

    @Test
    void setEmail() {
        this.mockAuthor.setEmail("newemail");
        Assertions.assertEquals(this.mockAuthor.getEmail(), "newemail");
    }

    @Test
    void setPhoneNumber() {
        this.mockAuthor.setPhoneNumber("newphone");
        Assertions.assertEquals(this.mockAuthor.getPhoneNumber(), "newphone");
    }

    @Test
    void setAge() {
        this.mockAuthor.setAge(40);
        Assertions.assertEquals(this.mockAuthor.getAge(), 40);
    }

    @Test
    void setPlace() {
        this.mockAuthor.setPlace("1000");
        Assertions.assertEquals(this.mockAuthor.getPlace(), "1000");
    }
}