package com.musicproject.musicMongo.service;

import com.musicproject.musicMongo.model.Artist;
import com.musicproject.musicMongo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist findByArtistName(String name) {
        return artistRepository.findByArtistName(name);
    }

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public List<Artist> findArtistNameLike(String name){ return artistRepository.findByArtistNameContainingIgnoreCase(name); }

}
