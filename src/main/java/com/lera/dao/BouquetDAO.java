package com.lera.dao;

import com.lera.entity.Bouquet;
import com.lera.entity.Holiday;

import java.util.List;
/**
 * Created by Михаил on 20.05.14.
 */
public interface BouquetDAO {
    List<Bouquet> find(Holiday holiday);
}
