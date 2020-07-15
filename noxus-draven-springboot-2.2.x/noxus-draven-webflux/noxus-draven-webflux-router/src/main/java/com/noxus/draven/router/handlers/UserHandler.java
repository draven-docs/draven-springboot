package com.noxus.draven.router.handlers;


import com.noxus.draven.router.domain.User;
import com.noxus.draven.router.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userRepository.findAll(), User.class);

    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userRepository.saveAll(user), User.class);

    }

    public Mono<ServerResponse> deleteUserById(ServerRequest request) {
        String id = request.pathVariable("id");
        return userRepository.findById(id)
                .flatMap(user ->
                        userRepository.delete(user).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());

    }
}
