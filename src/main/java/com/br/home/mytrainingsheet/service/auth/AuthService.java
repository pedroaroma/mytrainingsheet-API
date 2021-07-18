package com.br.home.mytrainingsheet.service.auth;

import com.br.home.mytrainingsheet.dto.customer.CustomerDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.Role;
import com.br.home.mytrainingsheet.enuns.ERole;
import com.br.home.mytrainingsheet.exception.customer.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.payload.request.LoginRequest;
import com.br.home.mytrainingsheet.payload.response.JwtResponse;
import com.br.home.mytrainingsheet.payload.response.MessageResponse;
import com.br.home.mytrainingsheet.repository.CustomerRepository;
import com.br.home.mytrainingsheet.repository.RoleRepository;
import com.br.home.mytrainingsheet.security.jwt.JwtUtils;
import com.br.home.mytrainingsheet.security.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final CustomerRepository customerRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    public ResponseEntity<?> signUp(CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {

        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        Customer customer = new Customer(customerDTO.getFullName(), customerDTO.getEmail(), encoder.encode(customerDTO.getPassword()));

        Set<String> strRoles = customerDTO.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        customer.setRoles(roles);
        customerRepository.save(customer);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }

    public ResponseEntity<?> signIn(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));

    }

}
