package inheritance.exercises.online_radio_database.exceptions;

public class InvalidArtistNameException extends InvalidSongException{
  
  public InvalidArtistNameException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
