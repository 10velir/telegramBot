package com.telegrambot.webservice.web.controller;

import com.telegrambot.webservice.dao.entity.City;
import com.telegrambot.webservice.exeption.NotFoundException;
import com.telegrambot.webservice.service.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.telegrambot.webservice.web.urlPath.UrlPath.API;
import static com.telegrambot.webservice.web.urlPath.UrlPath.CITY;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(API + CITY)
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @GetMapping("{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping
    public City createOrUpdate(@RequestBody City city) {
        city.setName(city.getName().toLowerCase());  // Для удобства работы с телеграм ботом все города привожу к lowerCase
        return cityService.saveOrUpdate(city);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        cityService.delete(id);
    }

}
