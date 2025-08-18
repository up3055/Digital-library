package com.example.Digital.library.Mapper.output;

import com.example.Digital.library.Entity.Output.MembershipOutputEntity;
import com.example.Digital.library.Entity.Output.UserOutputEntity;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.Model.UserModel;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MembershipOutputMapper {

//    private final MemberShipModel memberShipModel;
//    private final MembershipOutputEntity membershipOutputEntity;
//
//    public MembershipOutputMapper (MemberShipModel memberShipModel , MembershipOutputEntity membershipOutputEntity){
//        this.memberShipModel =memberShipModel;
//        this.membershipOutputEntity = membershipOutputEntity;
//    }

    private final UserOutputMapper userOutputMapper;

    @Autowired
    public MembershipOutputMapper (UserOutputMapper userOutputMapper){
        this.userOutputMapper= userOutputMapper;
    }

    public MemberShipModel mapToMode(MembershipOutputEntity membershipOutputEntity){

        UserModel userModel = this.userOutputMapper.mapToModel(membershipOutputEntity.getUser());

        return MemberShipModel.builder().startDate(membershipOutputEntity.getStartDate())
                .id(membershipOutputEntity.getId()).endDate(membershipOutputEntity.getEndDate())
                .user(userModel)
                .status(membershipOutputEntity.getStatus())
                .plan(membershipOutputEntity.getPlan()).build();
    }

    public MembershipOutputEntity mapFromModel(MemberShipModel memberShipModel){
        UserOutputEntity userOutputEntity = this.userOutputMapper.mapFromModel(memberShipModel.getUser());
        return MembershipOutputEntity.builder().user(userOutputEntity)
                .id(memberShipModel.getId()).status(memberShipModel.getStatus())
                .startDate(memberShipModel.getStartDate()).endDate(memberShipModel.getEndDate())
                .plan(memberShipModel.getPlan()).build();
    }

}
