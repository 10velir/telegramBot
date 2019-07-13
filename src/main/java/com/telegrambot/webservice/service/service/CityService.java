package com.telegrambot.webservice.service.service;

import com.telegrambot.webservice.dao.entity.City;
import com.telegrambot.webservice.dao.repository.CityRepository;
import com.telegrambot.webservice.dao.repository.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityService {

    private final CityRepository cityRepository;
    private final InformationRepository informationRepository;

    public Optional<City> getById(Long id) {
        return cityRepository.findById(id);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public City saveOrUpdate(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public void delete(Long id) {
        cityRepository.deleteCityById(id);
    }

    public String getCityInformation(String name) {
        return informationRepository.getCityInformation(name);
    }
}
