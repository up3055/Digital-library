package com.example.Digital.library.Repository.jpa;

import com.example.Digital.library.Entity.Output.UserOutputEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserOutputEntity , Long> {
    @Query("select u from UserOutputEntity u where upper(u.name) = upper(?1)")
    UserOutputEntity findByNameIgnoreCase(String name);

    void deleteByName(String name);

    boolean existsByName(String name);

    Optional<UserOutputEntity> findByEmail(String email);
}
