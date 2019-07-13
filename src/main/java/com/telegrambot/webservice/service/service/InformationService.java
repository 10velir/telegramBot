package com.telegrambot.webservice.service.service;

import com.telegrambot.webservice.dao.entity.Information;
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
public class InformationService {

    private final InformationRepository informationRepository;

    public Optional<Information> getById(Long id) {
        return informationRepository.findById(id);
    }

    public Optional<Information> getByName(String name) {
        return informationRepository.findByName(name);
    }

    public String getInformationByCityName(String name) {
        return informationRepository.getCityInformation(name);
    }

    public List<Information> getAll() {
        return informationRepository.findAll();
    }

    @Transactional
    public Information saveOrUpdate(Information information) {
        return informationRepository.save(information);
    }

    @Transactional
    public void delete(Long id) {
        informationRepository.deleteInformationById(id);
    }
}
