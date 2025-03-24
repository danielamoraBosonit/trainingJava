package com.realnaut.content.statistics.infrastructure.repository.jpa;

import com.realnaut.content.statistics.infrastructure.repository.jpa.entity.StatisticsJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepositoryJpa extends JpaRepository<StatisticsJpa, Long> {
}
