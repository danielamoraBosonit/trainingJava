package com.training.content.statistics_historic.infrastructure.repository.jpa;

import com.training.content.statistics_historic.infrastructure.repository.jpa.entity.StatisticsHistoricJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsHistoricRepositoryJpa extends JpaRepository<StatisticsHistoricJpa, Long> {
}
