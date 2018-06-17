package defining_classes.exercises.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    Map<String, Person> persons = new HashMap<>();
    
    String inLine = reader.readLine();
    createPerson(reader, persons, inLine);
    
    inLine = reader.readLine();
    Person person = persons.get(inLine);
    print(person);
  }
  
  private static void print(Person person) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(person.toString());
    stringBuilder.append(System.lineSeparator());
    
    printCompany(person, stringBuilder);
    printCar(person, stringBuilder);
    
    printPokemons(person, stringBuilder);
    
    printParents(person, stringBuilder);
    
    printChildren(person, stringBuilder);
    
    System.out.println(stringBuilder.toString());
  }
  
  private static void printChildren(Person person, StringBuilder stringBuilder) {
    stringBuilder.append("Children:");
    stringBuilder.append(System.lineSeparator());
    try {
      for (Child child : person.getChildren()) {
        stringBuilder.append(child.toString());
        stringBuilder.append(System.lineSeparator());
      }
    } catch (NullPointerException npe) {
    }
  }
  
  private static void printParents(Person person, StringBuilder stringBuilder) {
    stringBuilder.append("Parents:");
    stringBuilder.append(System.lineSeparator());
    try {
    
      for (Parent parent : person.getParents()) {
        stringBuilder.append(parent.toString());
        stringBuilder.append(System.lineSeparator());
      }
    } catch (NullPointerException npe) {
    }
  }
  
  private static void printPokemons(Person person, StringBuilder stringBuilder) {
    stringBuilder.append("Pokemon:");
    stringBuilder.append(System.lineSeparator());
    try {
      
      for (Pokemon pokemon : person.getPokemons()) {
        stringBuilder.append(pokemon.toString());
        stringBuilder.append(System.lineSeparator());
      }
    } catch (NullPointerException npe) {
    }
  }
  
  private static void printCar(Person person, StringBuilder stringBuilder) {
    stringBuilder.append("Car:");
    stringBuilder.append(System.lineSeparator());
    try {
      Car car = person.getCar();
      stringBuilder.append(car.toString());
      stringBuilder.append(System.lineSeparator());
    } catch (NullPointerException npe) {
    
    }
  }
  
  private static void printCompany(Person person, StringBuilder stringBuilder) {
    stringBuilder.append("Company:");
    stringBuilder.append(System.lineSeparator());
  
    try {
      Company company = person.getCompany();
      stringBuilder.append(company.toString());
      stringBuilder.append(System.lineSeparator());
      
    } catch (NullPointerException npe) {
    
    }
  }
  
  private static void createPerson(BufferedReader reader, Map<String, Person> persons, String inLine) throws IOException {
    while (!"End".equals(inLine)) {
      Person person = null;
      String[] inTokens = inLine.split(" ");
      String name = inTokens[0];
      String inputType = inTokens[1];
      
      if (!persons.containsKey(name)) {
        person = new Person(name);
        persons.put(name, person);
      }
      
      person = persons.get(name);
      
      switch (inputType) {
        case "company":
          createAndAddCompany(inTokens, person);
          break;
        case "pokemon":
          createAndAddPokemon(inTokens, person);
          break;
        case "parents":
          createAndAddParent(inTokens, person);
          break;
        case "children":
          createAndAddChild(inTokens, person);
          break;
        case "car":
          createAndAddCar(inTokens, person);
          break;
      }
      persons.put(name, person);
      inLine = reader.readLine();
    }
  }
  
  private static void createAndAddCar(String[] inTokens, Person person) {
    String model = inTokens[2];
    int speed = Integer.parseInt(inTokens[3]);
    Car car = new Car(model, speed);
    person.setCar(car);
  }
  
  private static void createAndAddChild(String[] inTokens, Person person) {
    String childName = inTokens[2];
    String childBirthDay = inTokens[3];
    Child child = new Child(childName, childBirthDay);
    person.addChild(child);
  }
  
  private static void createAndAddParent(String[] inTokens, Person person) {
    String parentName = inTokens[2];
    String parentBirthDay = inTokens[3];
    Parent parent = new Parent(parentName, parentBirthDay);
    person.addParent(parent);
  }
  
  private static void createAndAddPokemon(String[] inTokens, Person person) {
    String pokemonName = inTokens[2];
    String pokemonType = inTokens[3];
    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
    person.addPokemon(pokemon);
  }
  
  private static void createAndAddCompany(String[] inTokens, Person person) {
    String companyName = inTokens[2];
    String department = inTokens[3];
    double salary = Double.parseDouble(inTokens[4]);
    Company company = new Company(companyName, department, salary);
    person.setCompany(company);
  }
}
