package com.telegrambot.webservice.dao.repository;

import com.telegrambot.webservice.dao.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

    Optional<Information> findByName(String name);

    @Query(value = "SELECT inf.description FROM telegram_guide.information as inf JOIN telegram_guide.city as c ON inf.id = c.information_id WHERE c.name= :cityName", nativeQuery = true)
    String getCityInformation(@Param("cityName") String cityName);

    Long deleteInformationById(Long id);
}
