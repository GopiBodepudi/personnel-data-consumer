package com.aa.techops.supplychain.personnel.model.bronze;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.aa.techops.util.DataProcessorConstants.ID_FIELD;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "SPX001")
public class SPX001 {
    @Field(ID_FIELD)
    private String id;
    @Field("EMPLOYEE_NUMBER")
    private String employeeNumber;
    @Field("RAW_EMPLOYEE_NUMBER")
    private String rawEmployeeNumber;
    @Field("SRC_MODIFY_USER_ID")
    public String sRC_MODIFY_USER_ID;
    @Field("SRC_MODIFY_TMS")
    public String sRC_MODIFY_TMS;
    @Field("TGT_MODIFY_TMS")
    public String tGT_MODIFY_TMS;
    @Field("SRC_ACTION_CD")
    public String sRC_ACTION_CD;
}
