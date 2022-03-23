package com.aa.techops.supplychain.personnel.model.bronze;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.DateTimeException;
import java.util.Date;

import static com.aa.techops.util.DataProcessorConstants.ID_FIELD;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "SPE089")
public class SPE089 {
    @Field(ID_FIELD)
    private String id;
    @Field("TRAINING_CODE")
    private String trainingCode;
    @Field("SEQUENCE_NUMBER")
    private long sequenceNumber;
    @Field("NEXT_TRAINING_DUE_DATE")
    private Date nextTrainingDueDate;
    @Field("SPE001_RBA")
    private long spe001Rba;
    @Field("SRC_MODIFY_USER_ID")
    public String sRC_MODIFY_USER_ID;
    @Field("SRC_MODIFY_TMS")
    public String sRC_MODIFY_TMS;
    @Field("TGT_MODIFY_TMS")
    public String tGT_MODIFY_TMS;
    @Field("SRC_ACTION_CD")
    public String sRC_ACTION_CD;
}
