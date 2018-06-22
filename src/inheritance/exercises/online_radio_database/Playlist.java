package inheritance.exercises.online_radio_database;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
  private List<Song> songs;
  private int songsCnt;
  private int totalSecondsLength;
  
  public Playlist() {
    this.songs = new ArrayList<>();
  }
  
  public int getSongsCnt() {
    return this.songsCnt;
  }
  
  public void addSong(Song song) {
    this.songs.add(song);
    this.songsCnt++;
    addTime(song);
  }
  
  private void addTime(Song song) {
    int min = Integer.parseInt(song.getLength().split(":" )[0]);
    int sec = Integer.parseInt(song.getLength().split(":" )[1]);
    
    this.totalSecondsLength += (min * 60) + sec;
  }
  
  private String getTotalTime() {
    int hours = this.totalSecondsLength / 60 / 60;
    int minutes = (this.totalSecondsLength / 60) - (hours * 60);
    int seconds = this.totalSecondsLength % 60;
    
    return String.format("%dh %dm %ds", hours, minutes, seconds);
  }
  
  @Override
  public String toString() {
    return String.format("Songs added: %d%n" +
                         "Playlist length: %s", this.getSongsCnt(), this.getTotalTime());
  }
}
