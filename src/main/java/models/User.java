package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_accaunt")
public class User {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(name = "name")
    private String name;
    Set<MusicTypes> musicTypes = new HashSet<>();

    public void setMusicTypes(Set<MusicTypes> musicTypes) {
        this.musicTypes = musicTypes;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_MusicType",  joinColumns = {
            @JoinColumn(name = "Suser_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "musicType_id",
                    nullable = false, updatable = false) })
    public Set<MusicTypes> getMusicTypes() {
        return getMusicTypes();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //  @Column(name = "password")
    private String password;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private int age;

    @ElementCollection(targetClass = Role.class)
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<Role> interests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;


//    @ManyToMany(cascade = javax.persistence.CascadeType.ALL)
//    @JoinTable(name = "user_MusicType",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "musicType_id"))
//    private List<MusicTypes> musicTypes= new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
   // @PrimaryKeyJoinColumn
    private Address addressList;

    public User() {
    }

    public List<Role> getInterests() {
        return interests;
    }

    public void addMusicTypes(Address address) {

        address.setUser(this);

    }


    public void setInterests(List<Role> interests) {
        this.interests = interests;
    }

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
        //  addressList=new ArrayList<>();

        musicTypes = new HashSet<>();
        interests = new ArrayList<>();
        autos = new ArrayList<>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

//    public void addAddress(Address address) {
//        address.setUser(this);
//        //addressList.add(address);
//
//    }


//    public void addMusicType(MusicTypes musicType) {
//        List<User> users= new ArrayList<>();
//
//            musicType.setUsers(users);
//            musicTypes.add(users));
//
//
//
//    }

    public void removeAuto(MusicTypes musicType) {
        musicTypes.remove(musicType);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }




    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adress=" + addressList +
                '}';
    }


}
