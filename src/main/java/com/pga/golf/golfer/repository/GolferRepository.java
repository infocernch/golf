package com.pga.golf.golfer.repository;

import com.pga.golf.golfer.domain.GolferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GolferRepository extends JpaRepository<GolferEntity, Long> {


    GolferEntity findById(String id);
}
