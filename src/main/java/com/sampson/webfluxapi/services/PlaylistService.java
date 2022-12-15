package com.sampson.webfluxapi.services;

import com.sampson.webfluxapi.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist>findById(String id);

    Mono<Playlist>Save(Playlist playlist);
}
