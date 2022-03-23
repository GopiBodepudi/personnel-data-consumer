package com.aa.techops.supplychain.personnel.consumer;

import com.aa.techops.dto.ChangeStreamDto;
import com.aa.techops.service.DataConsumerService;
import com.aa.techops.supplychain.personnel.model.bronze.SPE089;
import com.aa.techops.supplychain.personnel.model.silver.HazmatTraining;
import com.aa.techops.supplychain.personnel.util.PersonnelConsumerUtil;
import com.mongodb.bulk.BulkWriteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Consumer;

@Component
@Slf4j
public class SPE089Consumer {
    private final DataConsumerService dataConsumerService;

    public SPE089Consumer(DataConsumerService dataConsumerService) {
        this.dataConsumerService = dataConsumerService;
    }

    @Bean
    public Consumer<Flux<Message<List<ChangeStreamDto>>>> spe089() {
        return changeStreamEventFlux -> changeStreamEventFlux.concatMap(this::processPePersonnel).subscribe();
    }

    private Mono<BulkWriteResult> processPePersonnel(Message<List<ChangeStreamDto>> changeStreamDtoMessage) {
        log.debug("Data received from spe089  : {}", changeStreamDtoMessage);;
        return dataConsumerService.processChangeStreamDTO(changeStreamDtoMessage, SPE089.class)
                .flatMap(documentBatchInfo ->Mono.just(PersonnelConsumerUtil.getDataProcessorRequest(documentBatchInfo,HazmatTraining.class,SPE089.class)))
                .flatMap(baseDataProcessorRequest -> dataConsumerService.executeProcessor(baseDataProcessorRequest,changeStreamDtoMessage,"SPE089"));
    }

}
