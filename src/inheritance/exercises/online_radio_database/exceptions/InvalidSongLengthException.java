package inheritance.exercises.online_radio_database.exceptions;

public class InvalidSongLengthException extends InvalidSongException{
  
  public InvalidSongLengthException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
