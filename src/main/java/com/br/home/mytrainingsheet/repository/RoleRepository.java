package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.Role;
import com.br.home.mytrainingsheet.enuns.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
