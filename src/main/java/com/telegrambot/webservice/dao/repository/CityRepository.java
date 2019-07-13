package com.telegrambot.webservice.dao.repository;

import com.telegrambot.webservice.dao.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String cityName);

    @Query("SELECT u FROM City u ")
    List<City> findAll();

    Long deleteCityById(Long id);
}
