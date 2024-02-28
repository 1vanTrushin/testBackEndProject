package org.van.model.dto;


import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ContactDTO {

    @NotBlank(message = "Invalid contact: Empty field")
    @NotNull(message = "Invalid contact: field is NULL")
    private String contact;

    @NotBlank(message = "Invalid category: Empty field")
    @NotNull(message = "Invalid category: field is NULL")
    //todo add validation to category (email or phone or another)
    private String category;


}
