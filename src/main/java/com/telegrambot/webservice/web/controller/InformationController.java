package com.telegrambot.webservice.web.controller;

import com.telegrambot.webservice.dao.entity.Information;
import com.telegrambot.webservice.exeption.NotFoundException;
import com.telegrambot.webservice.service.service.InformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class InformationController {

    private final InformationService informationService;

    @GetMapping("/description/{name}")
    public String getById(@PathVariable("name") String name) {
        return informationService.getInformationByCityName(name);
    }


    @GetMapping
    public List<Information> getAll() {
        return informationService.getAll();
    }

    @GetMapping("{id}")
    public Information getCityById(@PathVariable Long id) {
        return informationService.getById(id).orElseThrow(NotFoundException::new);
    }

    @PutMapping
    public Information createOrUpdate(@RequestBody Information information) {
        return informationService.saveOrUpdate(information);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        informationService.delete(id);
    }

}
