package com.telegrambot.webservice.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(of = {"name"})
@Builder
@Entity
@Table(name = "information", schema = "telegram_guide")

public class Information extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY)
    @JoinTable(name = "city", schema = "telegram_guide",
            joinColumns = @JoinColumn(name = "information_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private City city;

}
