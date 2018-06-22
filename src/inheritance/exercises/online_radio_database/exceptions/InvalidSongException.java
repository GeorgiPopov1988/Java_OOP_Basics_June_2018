package inheritance.exercises.online_radio_database.exceptions;

public class InvalidSongException extends Exception{
  
  public InvalidSongException(String message) {
    super(message);
  }
  
  @Override
  public String getMessage() {
    return super.getMessage();
  }

}
