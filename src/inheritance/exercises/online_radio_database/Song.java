package inheritance.exercises.online_radio_database;

import inheritance.exercises.online_radio_database.exceptions.*;

public class Song {
  private final static int MIN_NAME_LENGTH = 3;
  private final static int MAX_ARTIST_NAME_LENGTH = 20;
  private final static int MAX_SONG_NAME_LENGTH = 30;
  private final static int MIN_TIME = 0;
  private final static int MAX_MINUTES = 14;
  private final static int MAX_SECONDS = 59;
  
  private String artistName;
  private String songName;
  private String length;
  
  public Song(String artistName, String songName, String length) throws InvalidSongException {
    this.setArtistName(artistName);
    this.setSongName(songName);
    this.setLength(length);
  }
  
  private void setLength(String length) throws InvalidSongLengthException {
    //Song length should be between 0 second and 14 minutes and 59 seconds.
    //Song minutes should be between 0 and 14.
    //Song seconds should be between 0 and 59.
    String[] lengthTokens = length.split(":");
    int minutes;
    int seconds;
    try {
      minutes = Integer.parseInt(lengthTokens[0]);
      seconds = Integer.parseInt(lengthTokens[1]);
    } catch (Exception e) {
      throw new InvalidSongLengthException("Invalid song length.");
    }
    if (checkTime(minutes, MIN_TIME, MAX_MINUTES)) {
      throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
    }
  
    if (checkTime(seconds, MIN_TIME, MAX_SECONDS)) {
      throw new InvalidSongMinutesException("Song seconds should be between 0 and 59.");
    }
    this.length = length;
  }
  
  private boolean checkTime(int time, int minTime, int maxMinutes) {
    if (time < minTime || time > maxMinutes) {
      return true;
    } else {
      return false;
    }
  }
  
  private void setSongName(String songName) throws InvalidSongNameException {
    // •	Song name should be between 3 and 30 symbols.
    if (checkNameLength(songName, MIN_NAME_LENGTH, MAX_SONG_NAME_LENGTH)) {
      this.songName = songName;
    } else {
      throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
    }
  }
  
  private void setArtistName(String artistName) throws InvalidArtistNameException {
    // •	Artist name should be between 3 and 20 symbols.
    if (checkNameLength(artistName, MIN_NAME_LENGTH, MAX_ARTIST_NAME_LENGTH)) {
      this.artistName = artistName;
    } else {
      throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
    }
  }
  
  private boolean checkNameLength(String name, int minNameLength, int maxNameLength) {
    if (name.length() >= minNameLength && name.length() <= maxNameLength) {
      return true;
    } else {
      return false;
    }
  }
  
  public String getLength() {
    return this.length;
  }
}
