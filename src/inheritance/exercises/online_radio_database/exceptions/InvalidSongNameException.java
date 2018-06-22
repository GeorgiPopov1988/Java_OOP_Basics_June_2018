package inheritance.exercises.online_radio_database.exceptions;

public class InvalidSongNameException extends InvalidSongException{
  
  public InvalidSongNameException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }
}
