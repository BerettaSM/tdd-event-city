package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        Event event = eventRepository.getReferenceById(id);
        try {
            copyDtoToEntity(dto, event);
            event = eventRepository.save(event);
            return new EventDTO(event);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }

    private void copyDtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setDate(dto.getDate());
        entity.setCity(new City(dto.getCityId(), null));
    }

}
