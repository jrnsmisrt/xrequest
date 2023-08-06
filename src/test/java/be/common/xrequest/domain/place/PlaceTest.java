package be.common.xrequest.domain.place;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlaceTest {
    Place placeMock;

    @BeforeEach
    void setUp() {
        this.placeMock = new Place(1, "0001", "citymock", "statemock", "countrymock");
    }

    @AfterEach
    void tearDown() {
        this.placeMock = null;
    }

    @Test
    void getCity() {
        Assertions.assertEquals(this.placeMock.getCity(), "citymock");
    }

    @Test
    void getState() {
        Assertions.assertEquals(this.placeMock.getState(), "statemock");
    }

    @Test
    void getCountry() {
        Assertions.assertEquals(this.placeMock.getCountry(), "countrymock");
    }

    @Test
    void setCity() {
        this.placeMock.setCity("newcity");
        Assertions.assertEquals(this.placeMock.getCity(), "newcity");
    }

    @Test
    void setState() {
        this.placeMock.setState("newstate");
        Assertions.assertEquals(this.placeMock.getState(), "newstate");
    }

    @Test
    void setCountry() {
        this.placeMock.setCountry("newcountry");
        Assertions.assertEquals(this.placeMock.getCountry(), "newcountry");
    }

    @Test
    void getId() {
        Assertions.assertEquals(this.placeMock.getId(), 1);
    }

    @Test
    void setId() {
        this.placeMock.setId("2");
        Assertions.assertEquals(this.placeMock.getId(), 2);
    }

    @Test
    void getPostal() {
        Assertions.assertEquals(this.placeMock.getPostal(), "0001");
    }

    @Test
    void setPostal() {
        this.placeMock.setPostal("0002");
        Assertions.assertEquals(this.placeMock.getPostal(), "0002");
    }
}