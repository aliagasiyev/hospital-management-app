//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.edu.turing.hospitalmanagementapp.controller;

import az.edu.turing.hospitalmanagementapp.dto.auth.AuthenticationRequest;
import az.edu.turing.hospitalmanagementapp.dto.auth.AuthenticationResponse;
import az.edu.turing.hospitalmanagementapp.dto.auth.RegisterRequest;
import az.edu.turing.hospitalmanagementapp.service.impl.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/hospital/auth"})
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping({"/register"})
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponse register(@RequestBody RegisterRequest registerRequest) {
        return this.authenticationService.register(registerRequest);
    }

    @PostMapping({"/authenticate"})
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        return this.authenticationService.authenticate(authenticationRequest);
    }
}
