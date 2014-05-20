package com.lera.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Entity
@Table(name = "bouquets")
public class Bouquet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection(fetch=FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bouquet")
    private List<FlowerBank> flowerBanks;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "holiday_id", referencedColumnName = "id")
    private Holiday holiday;

    public Bouquet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<FlowerBank> getFlowerBanks() {
        return flowerBanks;
    }

    public void setFlowerBanks(List<FlowerBank> flowerBanks) {
        this.flowerBanks = flowerBanks;
    }
}
