package com.minh.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<MyUser> myUsers;

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyUser> getMyUsers() {
        return myUsers;
    }

    public void setMyUsers(List<MyUser> myUsers) {
        this.myUsers = myUsers;
    }
}
