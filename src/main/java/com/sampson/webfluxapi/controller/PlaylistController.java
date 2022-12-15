package com.sampson.webfluxapi.controller;

import com.sampson.webfluxapi.document.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sampson.webfluxapi.services.PlaylistService;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;

//@RestController
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping(value = "/playlist")
    public Flux<Playlist> getPlaylist(){
        return playlistService.findAll();
    }

    @GetMapping(value = "/playlist/{id}")
    public Mono<Playlist> getPLaylistId(@PathVariable String id){
        return playlistService.findById(id);
    }

    @PostMapping(value = "/playlist")
    public Mono<Playlist> savePlaylist(@RequestBody Playlist playlist){
        return playlistService.Save(playlist);
    }

    @GetMapping(value="/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){

        System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> playlistFlux = playlistService.findAll();

        return Flux.zip(interval, playlistFlux);

    }
}
