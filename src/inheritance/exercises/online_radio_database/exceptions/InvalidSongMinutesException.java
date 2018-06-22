package inheritance.exercises.online_radio_database.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException{
  
  public InvalidSongMinutesException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
