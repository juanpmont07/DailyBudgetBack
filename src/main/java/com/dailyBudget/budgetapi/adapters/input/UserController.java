package com.dailyBudget.budgetapi.adapters.input;

import com.dailyBudget.budgetapi.command.CreateUser;
import com.dailyBudget.budgetapi.infrastructure.dtos.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {


    private final CreateUser createUser;

    @Autowired
    public UserController (CreateUser createUser){
        this.createUser = createUser;
    }

    @GetMapping
    public Mono<String> version(){
        return Mono.just("1.0.0");
    }

    @PostMapping
    public Mono<ResponseEntity<String>> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
         return createUser.execute(registerUserDTO)
                 .map(message -> ResponseEntity.status(HttpStatus.CREATED).body(message));
         }

    @GetMapping("/users")
    public Mono<ResponseEntity<String>> getUserAll() {
        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("aquiiiii muchos usuarios"));
    }
}
