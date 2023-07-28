package be.common.xrequest.domain.place.dto;

public class PlaceDto {
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
}

