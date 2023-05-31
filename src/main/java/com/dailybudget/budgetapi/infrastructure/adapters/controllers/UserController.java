package com.dailybudget.budgetapi.infrastructure.adapters.controllers;

import com.dailybudget.budgetapi.application.command.user.CreateUserLogin;
import com.dailybudget.budgetapi.application.command.user.CreateUserInfo;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterLoginDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final CreateUserInfo createUserInfo;

    @Autowired
    private final CreateUserLogin createUserLogin;

    @GetMapping
    public Mono<String> version(){
        return Mono.just("1.0.0");
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<ResponseDTO>> registerLogin(@RequestBody RegisterLoginDTO loginUserDTO) {
        return createUserLogin.execute(loginUserDTO)
                .map(login->ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(login))
                ).onErrorResume(throwable -> {
                    String errorMessage = throwable.getMessage();
                    return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(errorMessage)));
                });
    }

    @GetMapping("/login")
    public Mono<ResponseEntity<String>> validateLogin(@RequestBody RegisterLoginDTO loginUserDTO) {
        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("se valida login"));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseDTO>> registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
         return createUserInfo.execute(registerUserDTO)
                 .map(user -> ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(user)))
                 .onErrorResume(throwable -> {
                     String errorMessage = throwable.getMessage();
                     HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                     return Mono.just(ResponseEntity.status(errorStatus).body(new ResponseDTO(errorMessage)));
                 });
    }

    @GetMapping("/users")
    public Mono<ResponseEntity<String>> getUserAll() {
        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("aquiiiii muchos usuarios"));
    }
/*
    @GetMapping("/example")
    public Mono<ResponseEntity<String>> example() {

        List<Integer> elementsMono = new ArrayList<>();
        List<Integer> elementsFlux = new ArrayList<>();

         Mono<Integer> mono = Mono.just(121);

         Flux<Integer> flux = Flux.just(12,14,19, 11,22,4,5,66,77);

         //suscrimos a mono

        mono.subscribe(elementsMono::add);

        flux.subscribe(elementsFlux::add);

        System.out.println(elementsMono);
        System.out.println(elementsFlux);

        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("ejercicio"));
    }

    @GetMapping("/example2")
    public Mono<ResponseEntity<String>> example2() {

       Mono<String> mono = Mono.just("Hola");

       mono.subscribe(
               data -> System.out.println(data),//onNext
               error -> System.out.println(error),//onError
               () -> System.out.println("complet")//onCOmplete
       );

        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("aquiiiii muchos usuarios"));
    }

    @GetMapping("/example3")
    public Mono<ResponseEntity<String>> example3() {

        Mono<String> mono = Mono.fromSupplier(() ->{
            throw new RuntimeException("excepcion ocurrida");
        });

        mono.subscribe(
                data -> System.out.println(data),//onNext
                error -> System.out.println(error),//onError
                () -> System.out.println("complet")//onCOmplete
        );

        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("aquiiiii muchos usuarios"));
    }


    @GetMapping("/example4")
    public Mono<ResponseEntity<String>> example4() {

        Flux<String> flux = Flux.fromArray(new String[]{"1", "2", "3"});

        flux.subscribe(System.out::println);

        flux.doOnNext(System.out::println).subscribe();

        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("aquiiiii muchos usuarios"));
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/example5")
    public Mono<ResponseEntity<String>> example5() {

        Flux<String> names = Flux.just("JUan pablo", "Jose montoya", "Ramiro jose", "Alxe aaaa");
        Flux<User> users = names.map(name -> new User(name.split(" ")[0].toUpperCase(), name.split(" ")[1].toUpperCase()) )
                .filter(user -> !user.getLastName().equalsIgnoreCase("aaaa"))
                .doOnNext(user -> {
                    if (user == null) {
                        throw new RuntimeException("The name can't stay empty");
                    }
                    System.out.println(user.getName().concat(" ").concat(user.getLastName()));
                })
                .map(user -> {
                    String name = user.getName().toLowerCase();
                    user.setName(name);
                    return user;
                });

        users.subscribe(e -> log.info(e.toString()), error -> log.error(error.getMessage()), new Runnable() {
            @Override
            public void run() {
                log.info("TODO MELO");
            }
        });

        return Mono.just( ResponseEntity.status(HttpStatus.ACCEPTED).body("example 5"));
    }*/
}
