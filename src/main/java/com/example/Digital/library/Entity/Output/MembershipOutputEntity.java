package com.example.Digital.library.Entity.Output;

import com.example.Digital.library.Enum.MemberShipPlan;
import com.example.Digital.library.Enum.MembershipStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "Membership")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private  long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private UserOutputEntity user;

    @Column(name = "startDate" , nullable = false)
    private Instant startDate;
    @Column(name = "endDate" , nullable = false)
    private Instant endDate;

    @Column(name = "Status")
//    @Enumerated(EnumType.STRING)
    private MembershipStatus status;

    @Column(name = "Plan")
//    @Enumerated(EnumType.STRING)
    private MemberShipPlan plan;




}
