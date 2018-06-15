package defining_classes.lab.bank_account_with_person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    Map<Integer, BankAcc> accounts = new HashMap<>();
    
    String inLine = reader.readLine();
    while (!"End".equalsIgnoreCase(inLine)) {
      String[] inTokens = inLine.split(" ");
      String command = inTokens[0];
      
      if ("Create".equalsIgnoreCase(command)) {
        BankAcc bankAcc = new BankAcc();
        //  Account ID1 created
        
        System.out.printf("Account ID%d created%n", bankAcc.getId());
        
        accounts.putIfAbsent(bankAcc.getId(), bankAcc);
      } else {
        int inputId = 0;
        double inInterest = 0.0d;
        
        switch (command) {
          
          case "Deposit":
            inputId = Integer.parseInt(inTokens[1]);
            double amount = Double.parseDouble(inTokens[2]);
            if (accounts.containsKey(inputId)){
              accounts.get(inputId).deposit(amount);
              System.out.printf("Deposited %.0f to ID%d%n", amount, inputId);
            } else {
              System.out.println("Account does not exist");
            }
            break;
            
          case "SetInterest":
            inInterest = Double.parseDouble(inTokens[1]);
            BankAcc.setInterest(inInterest);
            break;
            
          case "GetInterest":
            inputId = Integer.parseInt(inTokens[1]);
            int years = Integer.parseInt(inTokens[2]);
            if (accounts.containsKey(inputId)) {
              System.out.printf("%.2f%n", accounts.get(inputId).getInterest(years));
            } else {
              System.out.println("Account does not exist");
            }
            break;
        }
        
      }
      inLine = reader.readLine();
      
    }
    
    
  }
}
