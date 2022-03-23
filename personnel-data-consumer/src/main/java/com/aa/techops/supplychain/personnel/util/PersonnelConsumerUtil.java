package com.aa.techops.supplychain.personnel.util;

import com.aa.techops.model.BaseDataProcessorRequest;
import com.aa.techops.model.DocumentBatchInfo;
import com.aa.techops.supplychain.personnel.model.bronze.SPE001;
import com.aa.techops.supplychain.personnel.model.rest.SPE001Request;
import com.aa.techops.supplychain.personnel.model.rest.SPE089Request;
import com.aa.techops.supplychain.personnel.model.rest.SPX001Request;
import com.aa.techops.supplychain.personnel.model.silver.HazmatTraining;
import com.aa.techops.supplychain.personnel.model.silver.Personnel;
import com.aa.techops.supplychain.personnel.model.bronze.SPX001;
import com.aa.techops.supplychain.personnel.model.bronze.SPE089;


public class PersonnelConsumerUtil {
     public static BaseDataProcessorRequest getDataProcessorRequest(DocumentBatchInfo documentBatchInfo, Class targetCollectionClass, Class srcCollectionClass) {
        switch (documentBatchInfo.getSrcCollection()){
            case("SPE001"):
                return new SPE001Request(documentBatchInfo.getCollectionList(), documentBatchInfo.getDeleteList(),
                        documentBatchInfo.getSrcDB(), documentBatchInfo.getSrcCollection(), targetCollectionClass, srcCollectionClass);
            case("SPX001"):
                return new SPX001Request(documentBatchInfo.getCollectionList(), documentBatchInfo.getDeleteList(),
                        documentBatchInfo.getSrcDB(), documentBatchInfo.getSrcCollection(), targetCollectionClass, srcCollectionClass);
            case("SPE089"):
                return new SPE089Request(documentBatchInfo.getCollectionList(), documentBatchInfo.getDeleteList(),
                        documentBatchInfo.getSrcDB(), documentBatchInfo.getSrcCollection(), targetCollectionClass, srcCollectionClass);
        }
        return null;
    }
}
