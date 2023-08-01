package be.common.xrequest.domain.place;

import jakarta.persistence.*;

@Entity
public class Place {

    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "country")
    String country;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Integer id;

    @Column(name = "postal")
    String postal;

    public Place(Integer id, String postal, String city, String state, String country) {
        this.id = id;
        this.postal = postal;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Place() {
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Integer getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.valueOf(id);
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
