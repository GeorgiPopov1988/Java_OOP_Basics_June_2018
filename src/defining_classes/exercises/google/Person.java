package defining_classes.exercises.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private Company company;
  private List<Pokemon> pokemons;
  private List<Parent> parents;
  private List<Child> children;
  private Car car;
  
  public Person(String name) {
    this.name = name;
    this.pokemons = new ArrayList<>();
    this.parents = new ArrayList<>();
    this.children = new ArrayList<>();
  }
  
  public Company getCompany() {
    return this.company;
  }
  
  public void setCompany(Company company) {
    this.company = company;
  }
  
  public Car getCar() {
    return this.car;
  }
  
  public void setCar(Car car) {
    this.car = car;
  }
  
  public String getName() {
    return this.name;
  }
  
  public List<Pokemon> getPokemons() {
    return this.pokemons;
  }
  
  public void addPokemon(Pokemon pokemon) {
    this.pokemons.add(pokemon);
  }
  
  public List<Parent> getParents() {
    return this.parents;
  }
  
  public void addParent(Parent parent) {
    this.parents.add(parent);
  }
  
  public List<Child> getChildren() {
    return this.children;
  }
  
  public void addChild(Child child) {
    this.children.add(child);
  }
  
  @Override
  public String toString() {
    return this.getName();
  }
  
  
}
