package com.lera.entity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by panser on 5/10/14.
 */
@Entity
@Table(name = "flowerbanks")
public class FlowerBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer count;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_id")
    private Flower flower;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "bouquet_id", referencedColumnName = "id")
    private Bouquet bouquet;

    public FlowerBank() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Bouquet getBouquet() {
        return bouquet;
    }

    public void setBouquet(Bouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public String toString() {
        return "FlowerBank{" +
                "id=" + id +
                ", count=" + count +
                ", flower=" + flower +
                '}';
    }
}
