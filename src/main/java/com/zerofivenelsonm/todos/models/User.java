package com.zerofivenelsonm.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String primaryemail;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("user")
    private List<Todo> todos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "userroles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "todoid")
    )
    @JsonIgnoreProperties("users")
    List<Role> roles = new ArrayList<>();
}
