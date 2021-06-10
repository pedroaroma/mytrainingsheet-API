package com.br.home.mytrainingsheet.dto.customer;

import com.br.home.mytrainingsheet.entity.Sheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 120)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String password;

    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;

    private List<Sheet> sheets;

}
