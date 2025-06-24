package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.HouseMember;
import com.example.demo.repository.HouseRepository;
import com.example.demo.repository.HouseMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final HouseMemberRepository houseMemberRepository;

    public House createHouse(String name, String userId) {
        String inviteCode = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        House house = House.builder()
                .name(name)
                .createdBy(userId)
                .inviteCode(inviteCode)
                .build();
        houseRepository.save(house);

        HouseMember member = HouseMember.builder()
                .userId(userId)
                .house(house)
                .role("owner")
                .build();
        houseMemberRepository.save(member);

        return house;
    }
}
