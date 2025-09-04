package com.devsuperior.bds02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        return cityRepository.findAll(Sort.by("name"))
            .stream()
            .map(CityDTO::new)
            .toList();
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City(null, dto.getName());
        return new CityDTO(cityRepository.save(entity));
    }

    @Transactional
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

}
