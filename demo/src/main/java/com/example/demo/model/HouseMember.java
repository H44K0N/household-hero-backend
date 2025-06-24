package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseMember {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String userId; // Firebase UID

    @ManyToOne
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    @Column(nullable = false)
    private String role = "member";

    private Timestamp joinedAt;

    @PrePersist
    protected void onJoin() {
        joinedAt = new Timestamp(System.currentTimeMillis());
    }
}
