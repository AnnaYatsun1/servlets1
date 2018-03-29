package models;

import javax.persistence.*;

@Entity
@Table(name = "adress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Address(String city, String steet) {
        this.city = city;
        this.steet = steet;
    }

    @Column (name = "city")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSteet() {
        return steet;
    }

    public void setSteet(String steet) {
        this.steet = steet;
    }

    @Column (name = "steet")
    private String steet;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Address() {
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
