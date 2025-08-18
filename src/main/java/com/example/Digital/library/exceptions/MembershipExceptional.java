package com.example.Digital.library.exceptions;

public class MembershipExceptional extends RuntimeException{

    public MembershipExceptional(long userId , boolean isExist){

        super(String.format(
                "User with ID: %s %s an active membership.",
                userId,
                isExist ? "already has" : "does not have"
        ));
    }
}
