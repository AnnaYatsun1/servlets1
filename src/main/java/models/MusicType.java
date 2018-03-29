package models;

import javax.persistence.*;


public enum MusicType {
    RAP, ROCK, JAZZ, Folk, POP;

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

    @Column(name = "name")
    private String name;


    private User user;

}
