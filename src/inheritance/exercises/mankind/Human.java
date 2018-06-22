package inheritance.exercises.mankind;

public class Human {
  private final static int MIN_HUMAN_FIRST_NAME_LENGTH = 4;
  private final static int MIN_HUMAN_LAST_NAME_LENGTH = 3;
  
  
  private  String firstName;
  private String lastName;
  
  public Human(String firstName, String lastName) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
  }
  
  private void setFirstName(String firstName) {
    if(checkFirstLetter(firstName)) {
      if (checkNameLength(firstName, MIN_HUMAN_FIRST_NAME_LENGTH)) {
        this.firstName = firstName;
      } else {
        throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
      }
    } else {
      throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
    }
  }
  
  protected String getFirstName() {
    return this.firstName;
  }
  
  protected String getLastName() {
    return this.lastName;
  }
  
  protected void setLastName(String lastName) {
    if(checkFirstLetter(lastName)) {
      if (checkNameLength(lastName, MIN_HUMAN_LAST_NAME_LENGTH)) {
        this.lastName = lastName;
      } else {
        throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
      }
    } else {
      throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
    }
  }
  
  private boolean checkFirstLetter(String name) {
    char firstLetter = name.charAt(0);
    
    if (Character.isUpperCase(firstLetter)) {
      return true;
    } else {
      return false;
    }
  }
  
  protected boolean checkNameLength(String name, int minLength) {
    if (name.length() < minLength) {
      return false;
    } else {
      return true;
    }
  }
}
