package org.example.clientbank.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyCreateEmployer {
    @NotBlank
    private String name;

    @NotBlank
    private String address;
}
