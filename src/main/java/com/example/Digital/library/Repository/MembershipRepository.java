package com.example.Digital.library.Repository;


import com.example.Digital.library.Entity.Output.MembershipOutputEntity;
import com.example.Digital.library.Enum.MembershipStatus;
import com.example.Digital.library.Mapper.output.MembershipOutputMapper;
import com.example.Digital.library.Model.MemberShipModel;
import com.example.Digital.library.Repository.jpa.MembershipJPARepository;
import com.example.Digital.library.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class MembershipRepository {

    private final MembershipJPARepository membershipJPARepository;
    private final MembershipOutputMapper membershipOutputMapper;

    @Autowired
    public MembershipRepository(MembershipJPARepository membershipJPARepository, MembershipOutputMapper membershipOutputMapper) {
        this.membershipJPARepository = membershipJPARepository;
        this.membershipOutputMapper = membershipOutputMapper;
    }

    public MemberShipModel addMembership(MemberShipModel memberShipModel){
        MembershipOutputEntity outputEntity = this.membershipOutputMapper.mapFromModel(memberShipModel);
        outputEntity = this.membershipJPARepository.save(outputEntity);
        log.info("Saved new membership with ID: {} for user with ID: {}",
                outputEntity.getId(), outputEntity.getUser().getId());

        return this.membershipOutputMapper.mapToMode(outputEntity);
    }

    public MemberShipModel getMembershipById(long id ){
       return  this.membershipJPARepository.findById(id)
                .map((o) -> {
                    log.info("Membership with id: {} was successfully found." , id);
                    return this.membershipOutputMapper.mapToMode(o);
                }).orElseThrow(()-> new ResourceNotFoundException(MemberShipModel.class, "id" , String.valueOf(id)));


    }

    public MemberShipModel updateMembershipStatus(long membershipId , MembershipStatus status){

        MembershipOutputEntity outputEntity = this.membershipOutputMapper.mapFromModel(getMembershipById(membershipId));

        outputEntity.setStatus(status);
        outputEntity = this.membershipJPARepository.save(outputEntity);

        return this.membershipOutputMapper.mapToMode(outputEntity);
    }

    public Optional<MembershipOutputEntity> getNonExpiredMembershipForUser(long userId){
        return this.membershipJPARepository.findByUser_IdAndStatusNot(userId, MembershipStatus.EXPIRED);
    }







}

