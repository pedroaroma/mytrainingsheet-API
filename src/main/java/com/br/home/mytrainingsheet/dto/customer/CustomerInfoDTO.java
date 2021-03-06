package com.br.home.mytrainingsheet.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CustomerInfoDTO {

    private  Long id;

    @NotNull
    @Size(min = 1, max = 120)
    private String email;


    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;

}
