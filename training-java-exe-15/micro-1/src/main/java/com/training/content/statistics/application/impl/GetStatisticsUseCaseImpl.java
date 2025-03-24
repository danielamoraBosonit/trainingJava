package com.training.content.statistics.application.impl;

import com.training.content.statistics.application.GetStatisticsUseCase;
import com.training.content.statistics.application.mapper.StatisticsMapper;
import com.training.content.statistics.domain.entity.Statistics;
import com.training.content.statistics.domain.repository.GetStatisticsRepository;
import com.training.content.statistics.infrastructure.repository.dto.StatisticsOutputDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class GetStatisticsUseCaseImpl implements GetStatisticsUseCase {

    private String HOST_MICRO2;

    private final GetStatisticsRepository repo;

    private final StatisticsMapper mapper;


    public GetStatisticsUseCaseImpl(@Value("${micro2.host}") String HOST_MICRO2,
                                    GetStatisticsRepository repo, StatisticsMapper mapper) {
        this.HOST_MICRO2 = HOST_MICRO2;
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public StatisticsOutputDto getById(Long id){

        Optional<Statistics> statisticsOptional = repo.findById(id);

        if (statisticsOptional.isPresent()){
            log.info("Retrieving statistics form DB for product {} ", id);
            return mapper.domainToOutputDto(statisticsOptional.get());

        } else {
            log.info("Retrieving statistics form HTTP for product {} ", id);
            return getStatisticsFromHost(id);

        }
    }


    public List<Statistics> getAll(){

        return repo.findAll();

    }


    private StatisticsOutputDto getStatisticsFromHost(Long productId){

        WebClient webClient = WebClient.create(HOST_MICRO2);

        try {
            return webClient.get()
                    .uri("/api/statistics/"+ productId)
                    .retrieve()
                    .bodyToMono(StatisticsOutputDto.class)
                    .block();

        } catch (Exception e){
            log.error(e.getMessage());
        }

        return null;
    }

}
