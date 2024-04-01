package org.example.entity;

import jakarta.persistence.*;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@Table(name = "ssr_user")
@Entity

public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
