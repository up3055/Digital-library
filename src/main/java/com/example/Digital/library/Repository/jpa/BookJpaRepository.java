package com.example.Digital.library.Repository.jpa;

import com.example.Digital.library.Entity.Output.OutputEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<OutputEntity, Long> {


    boolean existsByName(String name);

    void deleteByName(String name);
}
