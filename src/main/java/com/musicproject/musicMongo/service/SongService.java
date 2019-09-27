package com.musicproject.musicMongo.service;

import com.musicproject.musicMongo.model.Song;
import com.musicproject.musicMongo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Optional<Song> findBySongId(String id) {
        return songRepository.findById(id);
    }

    public Song findBySongName(String songName) {
        return songRepository.findBySongName(songName);
    }

    public List<Song> findBySongsLike(String name){
        return songRepository.findBySongNameContainingIgnoreCase(name);
    }

}
