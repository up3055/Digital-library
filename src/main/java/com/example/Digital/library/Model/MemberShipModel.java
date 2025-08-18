package com.example.Digital.library.Model;

import com.example.Digital.library.Enum.MemberShipPlan;
import com.example.Digital.library.Enum.MembershipStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@Builder
@With
public class MemberShipModel {

    private long id;
    @JsonIgnore
    private UserModel user;

    private Instant startDate;
    private Instant endDate;
    private MembershipStatus status ;
    private MemberShipPlan plan;

   @JsonProperty
    public long getUserID(){
        return this.getUser().getId();
    }


}
