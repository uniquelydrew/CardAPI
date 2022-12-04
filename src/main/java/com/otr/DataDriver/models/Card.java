package com.otr.DataDriver.models;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.annotation.*;
import com.otr.DataDriver.hibernate.types.StringJsonUserType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table (name = "", schema = "public")
@JsonInclude(JsonInclude.Include.NON_NULL)
@TypeDefs( {
        @TypeDef( name= "StringJsonObject", typeClass = StringJsonUserType.class),
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})

@Data
public class Card {

    @Id
    @Column (name = "asset_id")
    public String assetId;

    @Column (name = "created_by")
    public String createdBy;

    @Column (name = "created_on")
    public Timestamp createdOn;

    @Column (name = "updated_by")
    public String updatedBy;

    @Column (name = "updated_on")
    public Timestamp updatedOn;

    @Column (name = "last_modified_by")
    public String lastModifiedBy;

    @Column (name = "last_modified_on")
    public Timestamp lastModifiedOn;

    @Column (name = "expired")
    public Boolean expired;

    @Column (name = "equipment_type")
    public String equipmentType;

    @Column (name = "origin_lon")
    public Double origin_lon;

    @Column (name = "origin_lat")
    public Double origin_lat;

    @Column (name = "origin_city")
    public String origin_city;

    @Column (name = "origin_state_province")
    public String origin_stateProvince;

    @Column (name = "destination_lon")
    public Double destination_lon;

    @Column (name = "destination_lat")
    public Double destination_lat;

    @Column (name = "destination_city")
    public String destination_city;

    @Column (name = "destination_state_province")
    public String destination_stateProvince;

    @Column (name = "rate")
    private Double rate;

    @Column (name = "rate_based_on")
    private String rateBasedOn;

    @Column (name = "rate_miles")
    private int rateMiles;

    @Transient
    public String posterId;

    @Column (name = "ltl")
    public Boolean ltl;

    @Column (name = "comments")
    @Type(type = "list-array")
    public List<String> comments = null;

    @Column (name = "count")
    public String count;

    @Column (name = "dimensions")
    @Type(type = "StringJsonObject")
    private String dimensions;

    @Column (name = "stops")
    public String stops;

    @Column (name = "available_from")
    public Timestamp availableFrom;

    @Column (name = "available_to")
    public Timestamp availableTo;

    @Column (name = "trip_miles")
    public Double tripMiles;

    @Column (name = "trip_method")
    public String tripMethod;

    @Column (name = "origin_deadhead_miles")
    public Double originDeadheadMiles;

    @Column (name = "origin_deadhead_method")
    public String originDeadheadMethod;

    @Column (name = "callback_user_id")
    public String callback_userId;

    @Column (name = "callback_phone_number")
    public String callback_phoneNumber;

    @Column (name = "callback_first_name")
    public String callback_firstName;

    @Column (name = "callback_last_name")
    public String callback_lastName;

    @Column (name = "callback_initials")
    public String callback_initials;

    @Column (name = "callback_company_name")
    public String callback_companyName;

    @Column (name = "callback_display_company")
    public String callback_displayCompany;

    @Column (name = "callback_posters_state_province")
    public String callback_postersStateProvince;

    @Column (name = "credit_score")
    @Type(type = "StringJsonObject")
    public String creditScore;

    @Column (name = "additional_details")
    @Type(type = "StringJsonObject")
    public String additionalDetails;

    @Column (name = "dot_ids")
    @Type(type = "StringJsonObject")
    public String dotIds = null;

    public void setDimensions(Object dimensions){
        this.dimensions = JsonUtils.toJsonString(dimensions);
    }

    public void setCreditScore(Object creditScore){
        this.creditScore = JsonUtils.toJsonString(creditScore);
    }

    public void setAdditionalDetails(Object additionalDetails){
        this.additionalDetails = JsonUtils.toJsonString(additionalDetails);
    }

    public void setDotIds(Object dotIds){
        this.dotIds = JsonUtils.toJsonString(dotIds);
    }

}
