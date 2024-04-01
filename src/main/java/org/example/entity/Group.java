package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ssr_gr")
public class Group {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "group")
    private List<User> userList;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
