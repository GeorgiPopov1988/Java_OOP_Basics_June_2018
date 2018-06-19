package encapsulation.exercises.shopping_spree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    Map<String, Person> people = new LinkedHashMap<>();
    createAndAddPeople(reader, people);
    
    Map<String, Product> products = new LinkedHashMap<>();
    createAndAddProducts(reader, products);
  
    String inLine = reader.readLine();
    
    while (!"END".equals(inLine)) {
      String[] inTokens = inLine.split("\\s+");
      String personName = inTokens[0];
      String productName = inTokens[1];
      
      if (people.containsKey(personName)) {
        if (products.containsKey(productName)) {
          
          Person person = people.get(personName);
          Product product = products.get(productName);
  
            person.buyProduct(product);
          
        }
      }
      
      inLine = reader.readLine();
    }
  
    for (Map.Entry<String, Person> map : people.entrySet()) {
      Person person = map.getValue();
      if (person.getProducts().size() > 0) {
        System.out.println(person);
      } else {
        System.out.printf("%s - Nothing bought", person.getName());
      }
    }
    
   // for (Map.Entry<String, Person> personMap : people.entrySet()) {
   //   String personName = personMap.getKey();
   //   if (personMap.getValue().getProducts().size() > 0) {
   //     List<Product> list = personMap.getValue().getProducts();
   //
   //     System.out.print(personName + " - ");
   //     System.out.println(String.join(", ", list.stream().map(p -> p.getName()).toArray(String[] :: new)));
   //
   //   }
   // }
   
   
  }
  
  private static void createAndAddProducts(BufferedReader reader, Map<String, Product> products) throws Exception {
    
    String[] tokens = reader.readLine().split(";");
    for (int i = 0; i < tokens.length; i++) {
      Product product = null;
      String[] inPersonTokens = tokens[i].split("=");
    
      try {
        String name = inPersonTokens[0];
        double price = Double.parseDouble(inPersonTokens[1]);
        product = new Product(name, price);
        
        products.put(name, product);
        
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    }
  }
  
  private static void createAndAddPeople(BufferedReader reader, Map<String, Person> people) throws Exception {
    String[] tokens = reader.readLine().split(";");
    
    for (int i = 0; i < tokens.length; i++) {
      Person person = null;
      String[] inPersonTokens = tokens[i].split("=");
      String name = inPersonTokens[0];
      int money = Integer.parseInt(inPersonTokens[1]);
  
      try {
        person = new Person(name, money);
        people.put(name, person);
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
      
    }
  }
}
