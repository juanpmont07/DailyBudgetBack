package com.dailyBudget.adapters.input;

import com.dailyBudget.command.CreateUser;
import com.dailyBudget.infrastructure.dtos.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {


    private final CreateUser createUser;

    @Autowired
    public UserController (CreateUser createUser){
        this.createUser = createUser;
    }

    @PostMapping
    public Mono<ResponseEntity<String>> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
         return createUser.execute(registerUserDTO)
                 .map(message -> ResponseEntity.status(HttpStatus.CREATED).body(message));
         }

    @GetMapping
    public Mono<ResponseEntity<String>> getUser() {
        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("message"));
    }
}
