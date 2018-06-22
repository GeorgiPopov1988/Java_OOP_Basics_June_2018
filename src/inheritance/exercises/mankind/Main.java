package inheritance.exercises.mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String inLine = reader.readLine();
    
    Student student = null;
    String[] studentTokens = inLine.split(" ");
    String studentFirstName = studentTokens[0];
    String strudentLastName = studentTokens[1];
    String facultyNumber = studentTokens[2];
    
    inLine = reader.readLine();
    
    Worker worker = null;
    String[] workerTokens = inLine.split(" ");
    String workerFirstName = workerTokens[0];
    String workerLastName = workerTokens[1];
    double salary = Double.parseDouble(workerTokens[2]);
    double workingHoursPerDay = Double.parseDouble(workerTokens[3]);
    
    try {
      student = new Student(studentFirstName, strudentLastName, facultyNumber);
      worker = new Worker(workerFirstName, workerLastName, salary, workingHoursPerDay);
      System.out.print(student);
      System.out.print(worker);
  
    } catch (IllegalArgumentException iae) {
      System.out.println(iae.getMessage());
    }
  
  
  }
}
