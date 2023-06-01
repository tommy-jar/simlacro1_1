package com.upc.simlacro1_1.repository;

import com.upc.simlacro1_1.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTourist  extends JpaRepository<Tourist, Long> {
    List<Tourist> findAllByStatus(String status);

    List<Tourist> findByStatusStartingWith(String status);

}
