package models;


import javax.persistence.*;

@Entity
@Table(name = "role")
public enum Role {

    USER, ADMIN, UNAUTHORIZED;
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

    @Column(name = "role")
    private String name;
}
