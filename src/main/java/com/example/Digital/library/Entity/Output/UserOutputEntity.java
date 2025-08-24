package com.example.Digital.library.Entity.Output;

import com.example.Digital.library.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserOutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "address" ,nullable = false)
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "date_of_birth" , nullable = false)
    private Instant dateOfBirth;
    @Column(name = "mobile_no" , nullable = false)
    private String mobileNo;
    @Column(name = "UserRole")
    private UserRole role;
}
