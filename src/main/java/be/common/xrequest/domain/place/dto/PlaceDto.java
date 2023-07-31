package be.common.xrequest.domain.place.dto;

public class PlaceDto {
    String id;
    String postal;
    String city;
    String state;
    String country;

    public String getCity() {
        return city;
    }

    public PlaceDto setCity(String city) {
        this.city = city;
        return this;

    }

    public String getState() {
        return state;
    }

    public PlaceDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public PlaceDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getId() {
        return id;
    }

    public PlaceDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getPostal() {
        return postal;
    }

    public PlaceDto setPostal(String postal) {
        this.postal = postal;
        return this;
    }
}

