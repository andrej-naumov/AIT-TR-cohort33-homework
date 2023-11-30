package lv.naumov.lesson54.enumeration;

import java.util.List;

//Пример использования
public class Main {
 public static void main(String[] args) {
     // Создание музыкальной библиотеки
     MusicLibrary library = new MusicLibrary();

     // Добавление нескольких альбомов с разными жанрами
     Album album1 = new Album("Album ABBA", "Artist 1", MusicGenre.POP);
     Album album2 = new Album("Album AC/DC", "Artist 2", MusicGenre.ROCK);
     Album album3 = new Album("Album NoName", "Artist 3", MusicGenre.CLASSICAL);
     Album album4 = new Album("Album NoName", "Artist 4", MusicGenre.JAZZ);

     library.addAlbum(album1);
     library.addAlbum(album2);
     library.addAlbum(album3);
     library.addAlbum(album4);

     // Получение альбомов заданного жанра и вывод информации о них
     MusicGenre genreToFilter = MusicGenre.CLASSICAL;
     List<Album> albumsByGenre = library.getAlbumsByGenre(genreToFilter);
     //MusicGenre[] genres = MusicGenre.values();
     
     String[] languages = {"en", "ru"}; // Английский и русский
     for (String language : languages) {
		String translatedGenre = genreToFilter.getI18N(language);
		System.out.println(" --- " + language + ": " + translatedGenre);
	}
     
     
     
     System.out.println("Альбомы жанра " + genreToFilter + ":");
     for (Album album : albumsByGenre) {
         System.out.println("Название: " + album.getTitle() + ", Исполнитель: " + album.getArtist()); 
     }
 }
}