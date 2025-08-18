package com.example.Digital.library.Repository.jpa;

import com.example.Digital.library.Entity.Output.MembershipOutputEntity;
import com.example.Digital.library.Enum.MembershipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipJPARepository extends JpaRepository<MembershipOutputEntity, Long> {

    Optional<MembershipOutputEntity> findByUser_IdAndStatusNot(long userId, MembershipStatus membershipStatus);
}
