package com.aa.techops.supplychain.personnel.consumer;

import com.aa.techops.dto.ChangeStreamDto;
import com.aa.techops.service.DataConsumerService;
import com.aa.techops.supplychain.personnel.model.bronze.SPE001;
import com.aa.techops.supplychain.personnel.model.silver.Personnel;
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
public class SPE001Consumer {
    private final DataConsumerService dataConsumerService;

    public SPE001Consumer(DataConsumerService dataConsumerService) {
        this.dataConsumerService = dataConsumerService;
    }

    @Bean
    public Consumer<Flux<Message<List<ChangeStreamDto>>>> spe001() {
        return changeStreamEventFlux -> changeStreamEventFlux.concatMap(this::processPePersonnel).subscribe();
    }

    private Mono<BulkWriteResult> processPePersonnel(Message<List<ChangeStreamDto>> changeStreamDtoMessage) {
        log.debug("Data received from spe001  : {}", changeStreamDtoMessage);;
        return dataConsumerService.processChangeStreamDTO(changeStreamDtoMessage, SPE001.class)
                .flatMap(documentBatchInfo ->Mono.just(PersonnelConsumerUtil.getDataProcessorRequest(documentBatchInfo, Personnel.class,SPE001.class)))
                .flatMap(baseDataProcessorRequest -> dataConsumerService.executeProcessor(baseDataProcessorRequest,changeStreamDtoMessage,"SPE001"));
    }

}
