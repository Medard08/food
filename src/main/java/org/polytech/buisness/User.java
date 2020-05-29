package org.polytech.buisness;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name =  "username")
    private String username;

    @Column(name = "password")
    private String password;


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
