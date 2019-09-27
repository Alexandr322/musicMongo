package com.musicproject.musicMongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Document(collection = "songs")
public class Song {

    @Id private String id;
    private String songName;
    private String text;
}
