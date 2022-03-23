package com.aa.techops.supplychain.personnel.model.rest;

import com.aa.techops.model.BaseDataProcessorRequest;
import com.aa.techops.supplychain.personnel.model.bronze.SPE089;
import com.aa.techops.supplychain.personnel.model.silver.HazmatTraining;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SPE089Request extends BaseDataProcessorRequest {
    List<SPE089> collectionList;
    List<String> deleteList;
    String srcDB;
    String srcCollection;
    Class<HazmatTraining> targetCollectionClass;
    Class<SPE089> srcCollectionClass;
}
