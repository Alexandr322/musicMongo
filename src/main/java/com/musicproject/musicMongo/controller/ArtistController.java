package com.musicproject.musicMongo.controller;

import com.musicproject.musicMongo.model.Artist;
import com.musicproject.musicMongo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping("artistsAll")
    private List<Artist> findAll() {
        return artistService.findAll();
    }

    @RequestMapping(value = "/artist/{name}")
    private Artist getArtistName(@PathVariable("name") String name){
        return artistService.findByArtistName(name);
    }

    @RequestMapping(value = "/artistLike/{name}")
    private List<Artist> getArtistNameLike(@PathVariable("name")String name){
        return artistService.findArtistNameLike(name)
                .stream()
                .filter(artist -> name.contains(name))
                .collect(Collectors.toList());
    }

}
