package com.example.demo.controller;

import com.example.demo.model.House;
import com.example.demo.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @PostMapping
    public House createHouse(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String userId = request.get("userId"); // Normally you'd extract this from auth token

        return houseService.createHouse(name, userId);
    }
}
