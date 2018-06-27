package interfaces_and_abstraction.exercises.telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] phoneNumbers = reader.readLine().split("\\s+");
    String[] urlAddresses = reader.readLine().split("\\s+");
  
    Smartphone smartphone = new Smartphone();
    
    for (String phoneNumber : phoneNumbers) {
      try {
        System.out.println(smartphone.call(phoneNumber));
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    }
  
    for (String urlAddress : urlAddresses) {
      try {
        System.out.println(smartphone.browse(urlAddress));
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    }
  }
}
