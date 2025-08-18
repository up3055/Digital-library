package com.example.Digital.library.Entity.Output;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Book")
public class OutputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "author" )
    private String author;

    @Column(name= "Description")
    private String description;

    @Column(name = "publishedDate")
    private Instant publishedDate;

    @Column(name = " createdAt")
    private Instant createdAt;
    @Column(name = "updatedAt")
    private Instant  updatedAt;


}
