package com.lera.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Entity
@Table(name = "holidays")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;
    private String description;



    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "holiday")
    private List<Bouquet> bouquets;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void assignToUser(User user){
        this.setUser(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
