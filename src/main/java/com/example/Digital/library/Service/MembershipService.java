package com.example.Digital.library.Service;


import com.example.Digital.library.Entity.Output.MembershipOutputEntity;
import com.example.Digital.library.Enum.MembershipStatus;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.Repository.MembershipRepository;
import com.example.Digital.library.exceptions.MembershipExceptional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MembershipService {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository){
        this.membershipRepository = membershipRepository;
    }

    public MemberShipModel addMembership(MemberShipModel memberShipModel){

        if(this.doesUserHaveActiveMembership(memberShipModel.getUserID())){
             throw new MembershipExceptional(memberShipModel.getUserID(), true);
        }

       return this.membershipRepository.addMembership(memberShipModel);
    }



    public MemberShipModel updateMembershipStatus(long userId , MembershipStatus status){
        Optional<MembershipOutputEntity> optional = this.membershipRepository.getNonExpiredMembershipForUser(userId);

        if(optional.isEmpty()){
            throw new MembershipExceptional(userId , false);
        }

        return this.membershipRepository.updateMembershipStatus(optional.get().getId() , status);
    }

     public boolean doesUserHaveActiveMembership(long userId){

         Optional<MembershipOutputEntity> optional = this.membershipRepository.getNonExpiredMembershipForUser(userId);

         if(optional.isPresent()){

             log.error("user with : {} have active membership with id : {}" , userId , optional.get().getId());

             return true;
         }
         log.info("The user with ID: {} does not have an active membership.", userId);
             return false;
     }
}
