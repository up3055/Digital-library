package com.example.Digital.library.Entity.Input;

import com.example.Digital.library.Enum.MemberShipPlan;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class MembershipInputEntity {

    @NotNull
    private long userId;

    @NotNull
    private MemberShipPlan plan;
}




