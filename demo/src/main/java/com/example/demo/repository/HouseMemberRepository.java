package com.example.demo.repository;

import com.example.demo.model.HouseMember;
import com.example.demo.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HouseMemberRepository extends JpaRepository<HouseMember, UUID> {
    Optional<HouseMember> findByUserId(String userId);
    List<HouseMember> findAllByHouse(House house);
}
