package com.lera.dao;

import com.lera.entity.Bouquet;
import com.lera.entity.Flower;
import com.lera.entity.FlowerBank;

import java.util.List;
import java.util.Set;

/**
 * Created by panser on 5/10/14.
 */
public interface FlowerBankDAO {
    FlowerBank find(Integer id);
    public List<FlowerBank> find(Bouquet bouquet);
    List<FlowerBank> findAll();
    FlowerBank merge(FlowerBank flowerBank);
    void delete(FlowerBank flowerBank);
}
