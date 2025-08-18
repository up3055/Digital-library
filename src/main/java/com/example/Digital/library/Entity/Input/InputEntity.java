package com.example.Digital.library.Entity.Input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputEntity {

    @NotBlank(message = "Name is mendatory")
    private String name;
    @NotBlank(message = "author is mendatory")
    private String author;
    private String description;
    @NotNull(message = "Publishedate is mendatory")
    private Instant publishedDate;

}
