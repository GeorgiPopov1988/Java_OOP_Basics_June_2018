package encapsulation.lab.sort_increase_validate_add_to_team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(reader.readLine());
    
    List<Person> people = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
      Person person = null;
      String[] input = reader.readLine().split(" ");
      String firstName = input[0];
      String lastName = input[1];
      int age = Integer.parseInt(input[2]);
      double salary = Double.parseDouble(input[3]);
      
      try {
        person = new Person(firstName, lastName, age, salary);
        people.add(person);
        
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    }
    
    // Sort in alphabetic order
    //Collections.sort(people, (firstPerson, secondPerson) -> {
    //  int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
    //
    //  if (sComp != 0) {
    //    return sComp;
    //  } else {
    //    return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
    //  }
    //});
    
    //double bonus = Double.parseDouble(reader.readLine());
    //
    //for (Person person : people) {
    //  person.increaseSalary(bonus);
    //  System.out.println(person.toString());
    //}
    String teamName = reader.readLine();
    Team team = new Team(teamName);
  
    for (Person person : people) {
      team.addPlayer(person);
    }
  
    System.out.println("First team have " + team.getFirstTeam().size() + " players");
    System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    
  }
}
