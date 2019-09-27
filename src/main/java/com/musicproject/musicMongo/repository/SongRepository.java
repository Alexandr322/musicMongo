package com.musicproject.musicMongo.repository;

import com.musicproject.musicMongo.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends MongoRepository<Song,String> {

    Optional<Song> findById(String name);

    Song findBySongName(String name);

    List<Song> findBySongNameContainingIgnoreCase(String songName);

}
