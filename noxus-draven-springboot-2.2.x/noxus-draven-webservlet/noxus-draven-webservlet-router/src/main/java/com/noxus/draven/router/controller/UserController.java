//package com.noxus.draven.router.controller;
//
//import com.noxus.draven.router.domain.User;
//import com.noxus.draven.router.repository.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/user")
//@Slf4j
//public class UserController {
//    private final UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping(value = "/")
//    public Flux<User> getAll() {
//        return userRepository.findAll();
//    }
//
//
//    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<User> streamGetAll() {
//        return userRepository.findAll();
//    }
//
//    @PostMapping(value = "/stream/save")
//    public Mono<User> save(@Valid @RequestBody User user) {
//        user.setId(null);
//        return userRepository.save(user);
//    }
//
//
//    @DeleteMapping(value = "/stream/delete/{id}")
//    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
//        return userRepository.findById(id).flatMap(user -> userRepository.delete(user).then(
//                Mono.just(new ResponseEntity<Void>((HttpStatus.OK)))).defaultIfEmpty(
//                new ResponseEntity<>(HttpStatus.NOT_FOUND)
//        ));
//    }
//
//    @PutMapping(value = "/stream/put/{id}")
//    public Mono<ResponseEntity<User>> putUser(@PathVariable("id") String id, @RequestBody User user) {
//        return userRepository.findById(id).flatMap(
//                u -> {
//                    u.setAge(user.getAge());
//                    u.setName(user.getName());
//                    return userRepository.save(u);
//                }).map(u -> new ResponseEntity<User>((HttpStatus.OK)))
//                .defaultIfEmpty(
//                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
//                );
//    }
//
//    @GetMapping(value = "/stream/findById/{id}")
//    public Mono<ResponseEntity<User>> findUserById(@PathVariable("id") String id) {
//        log.info(id);
//        log.info(userRepository.findById(id) + "1");
//        return userRepository.findById(id).map(u -> new ResponseEntity<User>(u, HttpStatus.OK))
//                .defaultIfEmpty(
//                        new ResponseEntity<>(HttpStatus.NOT_FOUND)
//                );
//    }
//
//}
