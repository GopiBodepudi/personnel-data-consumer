package com.aa.techops.supplychain.personnel.model.rest;

import com.aa.techops.model.BaseDataProcessorRequest;
import com.aa.techops.supplychain.personnel.model.bronze.SPX001;
import com.aa.techops.supplychain.personnel.model.silver.Personnel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SPX001Request extends BaseDataProcessorRequest {
    List<SPX001> collectionList;
    List<String> deleteList;
    String srcDB;
    String srcCollection;
    Class<Personnel> targetCollectionClass;
    Class<SPX001> srcCollectionClass;
}
