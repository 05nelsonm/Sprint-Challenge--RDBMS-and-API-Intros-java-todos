package com.zerofivenelsonm.todos.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @Column(unique = true, nullable = false)
    private String rolename;

    @ManyToMany(mappedBy = "userroles")
    private List<User> users = new ArrayList<>();
}
