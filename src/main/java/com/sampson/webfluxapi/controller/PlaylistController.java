package com.sampson.webfluxapi.controller;

import com.sampson.webfluxapi.document.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sampson.webfluxapi.services.PlaylistService;

@RestController
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
}
