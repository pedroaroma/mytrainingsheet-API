package com.br.home.mytrainingsheet.controller.Auth;

import com.br.home.mytrainingsheet.dto.customer.CustomerDTO;
import com.br.home.mytrainingsheet.exception.customer.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.payload.request.LoginRequest;
import com.br.home.mytrainingsheet.service.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {
        return authService.signUp(customerDTO);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }


}
