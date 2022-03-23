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
@Document(value = "SPE001")
public class SPE001 {

    @Field(ID_FIELD)
    private String id;
    @Field("EMPLOYEE_NUMBER")
    private String employeeNumber;
    @Field("FIRST_NAME")
    private String firstName;
    @Field("LAST_NAME")
    private String lastName;
    @Field("MIDDLE_NAME")
    private String middleName ;
    @Field("JOB_POSITION")
    private String jobPosition;
    @Field("DEPARTMENT")
    private String department;
    @Field("STATION_ASSIGNED")
    private String stationAssigned;
    @Field("EMPLOYEE_STATUS_IND")
    private String employeeStatusInd;
    @Field("DIVISION_CREW")
    private long divisionCrew;
    @Field("MANAGER_SECTION")
    private long managerSection;
    @Field("NUMERIC_STATION")
    private long numericStation;
    @Field("SPE001_RBA")
    private long spe001Rba;
    @Field("OFFICE_PHONE_NUMBER")
    private long officePhoneNumber;
    @Field("SRC_MODIFY_USER_ID")
    public String sRC_MODIFY_USER_ID;
    @Field("SRC_MODIFY_TMS")
    public String sRC_MODIFY_TMS;
    @Field("TGT_MODIFY_TMS")
    public String tGT_MODIFY_TMS;
    @Field("SRC_ACTION_CD")
    public String sRC_ACTION_CD;
}
