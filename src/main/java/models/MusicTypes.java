package models;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "MusicTypes")
public class MusicTypes {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MusicTypes(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "musicTypes")
    private Set<User> users = new HashSet<User>(0);

    public MusicTypes(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }



}
