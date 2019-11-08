package com.zerofivenelsonm.todos.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @Column(unique = true, nullable = false)
    private String rolename;
}