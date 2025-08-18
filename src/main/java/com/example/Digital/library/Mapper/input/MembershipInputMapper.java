package com.example.Digital.library.Mapper.input;

import com.example.Digital.library.Entity.Input.MembershipInputEntity;

import com.example.Digital.library.Enum.MemberShipPlan;
import com.example.Digital.library.Enum.MembershipStatus;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.Model.UserModel;
import com.example.Digital.library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class MembershipInputMapper {

    private final UserRepository userRepository;
    @Autowired
     public MembershipInputMapper (UserRepository userRepository ){
         this.userRepository = userRepository;
     }


    public MemberShipModel mapToModel(MembershipInputEntity inputEntity){
        UserModel  userModel =  this.userRepository.findByID(inputEntity.getUserId());
        Instant[] startEnd = this.startAndEndTime(inputEntity);

        return MemberShipModel.builder()
                .user(userModel)
                .startDate(startEnd[0])
                .endDate(startEnd[1])
                .status(MembershipStatus.ACTIVE)
                .plan(inputEntity.getPlan()).build();
    }

    private Instant[] startAndEndTime(MembershipInputEntity inputEntity){
        MemberShipPlan plan = inputEntity.getPlan();
        Instant start = Instant.now();
        Instant end = null;

        switch(plan){
            case THREE_MONTHS -> end = this.addMonthToInstant(start , 3);
            case SIX_MONTHS ->  end = this.addMonthToInstant(start , 6);
            case ONE_YEAR ->  end = this.addMonthToInstant(start , 12);
        }

        return new Instant[]{start , end};
    }
    private Instant addMonthToInstant(Instant instant , int addMonth){

        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        ZonedDateTime updated = zonedDateTime.plusMonths(addMonth);

        return updated.toInstant();
    }

}


