package java.basic.naumov.lesson54.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Album {
    private final String title;
    private final String artist;
    private final MusicGenre genre;
}
