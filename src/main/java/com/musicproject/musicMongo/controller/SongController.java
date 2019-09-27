package com.musicproject.musicMongo.controller;

import com.musicproject.musicMongo.model.Song;
import com.musicproject.musicMongo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping(value = "/song/{id}")
    private Optional<Song> getBySongId(@PathVariable ("id")String id)  {
        return songService.findBySongId(id);
    }

    @RequestMapping(value = "/songName/{name}")
    private Song getBySongName(@PathVariable("name")String name){
        return songService.findBySongName(name);
    }

    @RequestMapping(value = "/songLike/{name}")
    private List<Song> getSongsLike(@PathVariable("name")String name) {
        return songService.findBySongsLike(name)
                .stream()
                .filter(songs1 -> name.contains(name))
                .collect(Collectors.toList());
    }

}
