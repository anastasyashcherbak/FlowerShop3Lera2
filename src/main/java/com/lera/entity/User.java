package com.lera.entity;


import javax.persistence.*;

/**
 * Created by panser on 5/18/14.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private boolean enabled;
    private String role;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userCalendar_id")
    @OneToOne(mappedBy = "user")
    private UserCalendar userCalendar;

    public User() {
        enabled = true;
        role = "ROLE_USER";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserCalendar getUserCalendar() {
        return userCalendar;
    }

    public void setUserCalendar(UserCalendar userCalendar) {
        this.userCalendar = userCalendar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", userCalendar=" + userCalendar +
                '}';
    }
}
