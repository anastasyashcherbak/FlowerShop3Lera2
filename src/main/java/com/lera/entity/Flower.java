package com.lera.entity;

import com.lera.entity.notPersistence.Colored;
import com.lera.entity.notPersistence.Plant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by panser on 5/10/14.
 */
@Entity
@Table(name = "flowers")
public class Flower extends Plant implements Colored, Serializable{
    protected String color;

    @OneToOne(mappedBy = "flower")
    private FlowerBank flowerBank;

    public FlowerBank getFlowerBank() {
        return flowerBank;
    }

    public void setFlowerBank(FlowerBank flowerBank) {
        this.flowerBank = flowerBank;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public Flower() {
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                "name='" + getName() + '\'' +
                '}';
    }
}
