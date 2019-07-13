package com.telegrambot.webservice.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true, exclude = {"information"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"name"})
@Builder
@Entity
@Table(name = "city", schema = "telegram_guide")
public class City extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Information> information;

}
