package defining_classes.exercises.define_Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
    List<Person> persons = new ArrayList<>();
    int personsCnt = Integer.parseInt(reader.readLine());
    
    while (personsCnt-- > 0) {
      String[] personTokens = reader.readLine().split(" ");
      String name = personTokens[0];
      int age = Integer.parseInt(personTokens[1]);
      
      Person person = new Person(name, age);
      persons.add(person);
    }
    
    persons.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    persons.stream()
            .filter(p -> p.getAge() > 30)
            .forEach(p -> System.out.printf("%s - %s%n", p.getName(), p.getAge()));
  }
  
}
