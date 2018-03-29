package models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name_of_role")
    private String role;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице



    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Auto() {
    }

    public Auto(String role) {
        this.role = role;

    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return  " " + role;
    }
}
