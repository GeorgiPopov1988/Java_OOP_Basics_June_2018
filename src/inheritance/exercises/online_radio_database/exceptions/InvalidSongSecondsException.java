package inheritance.exercises.online_radio_database.exceptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
  
  public InvalidSongSecondsException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
