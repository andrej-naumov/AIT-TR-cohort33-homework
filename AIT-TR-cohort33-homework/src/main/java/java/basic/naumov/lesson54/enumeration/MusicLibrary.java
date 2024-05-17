package java.basic.naumov.lesson54.enumeration;

import java.util.ArrayList;
import java.util.List;

//Класс музыкальной библиотеки
class MusicLibrary {
 private final List<Album> albums;

 public MusicLibrary() {
     this.albums = new ArrayList<>();
 }

 // Метод для добавления альбома в библиотеку
 public void addAlbum(Album album) {
     albums.add(album);
 }

 // Метод для получения списка альбомов заданного жанра
 public List<Album> getAlbumsByGenre(MusicGenre genre) {
     List<Album> filteredAlbums = new ArrayList<>();
     for (Album album : albums) {
         if (album.getGenre() == genre) {
             filteredAlbums.add(album);
         }
     }
     return filteredAlbums;
 }
}