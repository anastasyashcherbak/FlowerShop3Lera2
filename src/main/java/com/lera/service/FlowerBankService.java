package com.lera.service;

import com.lera.dao.FlowerBankDAO;
import com.lera.entity.FlowerBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by panser on 5/10/14.
 */
@Service
@Transactional
public class FlowerBankService {
    @Autowired
    private FlowerBankDAO flowerBankDAO;

    @Transactional(readOnly = true)
    public FlowerBank find(Integer id) {
        FlowerBank flowerBank = flowerBankDAO.find(id);
        return flowerBank;
    }

    @Transactional(readOnly = true)
    public List<FlowerBank> findAll() {
        List results = flowerBankDAO.findAll();
        return results;
    }

    @Transactional(rollbackFor = Exception.class)
    public FlowerBank merge(FlowerBank flowerBank) {
        FlowerBank flowerBankNew = flowerBankDAO.merge(flowerBank);
        return flowerBankNew;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(FlowerBank flowerBank) {
        flowerBankDAO.delete(flowerBank);
    }
}
