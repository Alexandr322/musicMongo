package com.musicproject.musicMongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "artist")
public class Artist {

    @Id private String id;
    private String artistName;
    private List<Song> songs;
}
