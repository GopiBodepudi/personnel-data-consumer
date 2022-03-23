package com.aa.techops.supplychain.personnel.model.rest;

import com.aa.techops.model.BaseDataProcessorRequest;
import com.aa.techops.supplychain.personnel.model.bronze.SPE001;
import com.aa.techops.supplychain.personnel.model.silver.Personnel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SPE001Request extends BaseDataProcessorRequest {
    List<SPE001> collectionList;
    List<String> deleteList;
    String srcDB;
    String srcCollection;
    Class<Personnel> targetCollectionClass;
    Class<SPE001> srcCollectionClass;
}
