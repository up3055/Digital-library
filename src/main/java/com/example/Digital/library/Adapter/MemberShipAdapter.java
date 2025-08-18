package com.example.Digital.library.Adapter;

import com.example.Digital.library.Entity.Input.MembershipInputEntity;
import com.example.Digital.library.Enum.MembershipStatus;
import com.example.Digital.library.Mapper.input.MembershipInputMapper;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.Service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberShipAdapter {

    final private MembershipService membershipService;

    final private MembershipInputMapper membershipInputMapper;
    @Autowired
    public MemberShipAdapter(MembershipService membershipService ,MembershipInputMapper membershipInputMapper){
        this.membershipService = membershipService;
        this.membershipInputMapper = membershipInputMapper;
    }

    public MemberShipModel  addMemberShip(MembershipInputEntity inputEntity){
        return this.membershipService.addMembership(this.membershipInputMapper.mapToModel(inputEntity));

    }

    public MemberShipModel updateMembership(long userId , MembershipStatus status){
        return this.membershipService.updateMembershipStatus(userId , status);
    }


}
