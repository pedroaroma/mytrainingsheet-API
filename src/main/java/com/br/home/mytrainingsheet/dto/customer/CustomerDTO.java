package com.br.home.mytrainingsheet.dto.customer;

import com.br.home.mytrainingsheet.entity.Role;
import com.br.home.mytrainingsheet.entity.Sheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 120)
    private String email;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;

    private List<Sheet> sheets;

    private Set<String> role;

}
