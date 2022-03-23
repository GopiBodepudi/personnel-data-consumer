package com.aa.techops.supplychain.personnel;

import com.aa.techops.config.TechopsMongoConfig;
import com.aa.techops.service.MongoConverterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({TechopsMongoConfig.class, MongoConverterService.class})
@ComponentScan(basePackages = { "com.aa.techops"})
public class PersonnelDataConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonnelDataConsumerApplication.class, args);
	}

}
