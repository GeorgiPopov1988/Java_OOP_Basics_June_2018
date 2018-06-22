package inheritance.exercises.online_radio_database;

import inheritance.exercises.online_radio_database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(reader.readLine());
    Playlist playlist = new Playlist();
    
    while (cnt-- > 0) {
      String[] inTokens = reader.readLine().split(";");
      String artistName = inTokens[0];
      String songName = inTokens[1];
      String length = inTokens[2];
  
      //Song song = null;

      try {
        Song song = new Song(artistName, songName, length);
        playlist.addSong(song);
        System.out.println("Song added.");
      } catch (InvalidSongException e) {
        System.out.println(e.getMessage());
      }
  
    }
    System.out.println(playlist);
  }
}
