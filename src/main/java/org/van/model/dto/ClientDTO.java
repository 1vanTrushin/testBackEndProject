package org.van.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientDTO {

    @NotBlank(message = "Invalid firstName: Empty field")
    @NotNull(message = "Invalid firstName: field is NULL")
    private String firstName;
    @NotBlank(message = "Invalid lastName: Empty field")
    @NotNull(message = "Invalid lastName: field is NULL")
    private String lastName;


}
