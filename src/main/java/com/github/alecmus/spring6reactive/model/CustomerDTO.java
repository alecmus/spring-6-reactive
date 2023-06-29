package com.github.alecmus.spring6reactive.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    @Id
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
