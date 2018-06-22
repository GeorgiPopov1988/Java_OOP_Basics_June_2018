package inheritance.exercises.mankind;

public class Student extends Human{
  private final static int MIN_FACULTY_NUMER_LENGTH = 5;
  private final static int MAX_FACULTY_NUMER_LENGTH = 10;
  
  private String facultyNumber;
  
  public Student(String firstName, String lastName, String facultyNumber) {
    super(firstName, lastName);
    this.setFacultyNumber(facultyNumber);
  }
  
  private void setFacultyNumber(String facultyNumber) {
   
    if (checkNumberLength(facultyNumber, MIN_FACULTY_NUMER_LENGTH, MAX_FACULTY_NUMER_LENGTH)) {
      this.facultyNumber = facultyNumber;
    } else {
      throw new IllegalArgumentException("Invalid faculty number!");
    }
  }
  
  private String getFacultyNumber() {
    return this.facultyNumber;
  }
  
  private boolean checkNumberLength(String facultyNumber, int minLength, int maxLength) {
    return facultyNumber.length() >= minLength && facultyNumber.length() <= maxLength;
  }
  
  @Override
  public String toString() {
    return String.format("First Name: %s\n" +
                         "Last Name: %s\n" +
                         "Faculty number: %s\n"
                          , this.getFirstName(), this.getLastName(), this.getFacultyNumber());
  }
}
