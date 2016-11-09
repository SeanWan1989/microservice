package org.sean.service;

import org.sean.domain.City;
import org.sean.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by wanlichao on 2016/10/26 0026.
 */
public class CityService {
    @Autowired
    private CityMapper mapper;

    @Transactional
    public void updateCountryById(City city){
        System.out.println(mapper.updateCountryById(city));
        //throw new NumberFormatException();
    }

    public City selectCityById(int city_id){
        return mapper.selectCityById(city_id);
    }
}
