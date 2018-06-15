package defining_classes.lab.bank_account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    Map<Integer, BankAccount> accounts = new HashMap<>();
    
    String inLine = reader.readLine();
    while (!"End".equalsIgnoreCase(inLine)) {
      String[] inTokens = inLine.split(" ");
      String command = inTokens[0];
      int id = Integer.parseInt(inTokens[1]);
      
      switch (command) {
        case "Create":
          if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
          } else {
            BankAccount bankAccount = new BankAccount(id);
            accounts.put(id, bankAccount);
          }
          break;
        case "Deposit":
          if (checkAccExist(accounts, id)) break;
          double depositAmount = Double.parseDouble(inTokens[2]);
          accounts.get(id).deposit(depositAmount);
          break;
        case "Withdraw":
          if (checkAccExist(accounts, id)) break;
          double withdrawAmount = Double.parseDouble(inTokens[2]);
          BankAccount bankAccount1 = accounts.get(id);
          
          if (withdrawAmount > bankAccount1.getBalance()) {
            System.out.println("Insufficient balance");
          } else {
            bankAccount1.withdraw(withdrawAmount);
          }
          break;
        case "Print":
          if (checkAccExist(accounts, id)) break;
          System.out.println(accounts.get(id));
          break;
      }
      
      inLine = reader.readLine();
    }
    
    
  }
  
  private static boolean checkAccExist(Map<Integer, BankAccount> accounts, int id) {
    if (!accounts.containsKey(id)) {
      System.out.println("Account does not exist");
      return true;
    }
    return false;
  }
}
