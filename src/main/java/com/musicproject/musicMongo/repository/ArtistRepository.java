package com.musicproject.musicMongo.repository;

import com.musicproject.musicMongo.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends MongoRepository<Artist,String> {

    Artist findByArtistName(String name);

    List<Artist> findByArtistNameContainingIgnoreCase(String name);

}
