package defining_classes.lab.bank_account_with_person;

public class BankAcc {
  private final static double DEFAULT_INTEREST = 0.02;
  private static double rate = DEFAULT_INTEREST;
  private static int bankAccCounter;
  
  private int id;
  private double balance;
  
  
  public BankAcc () {
    this.id = ++ bankAccCounter;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public int getId() {
    return this.id;
  }
  
  public static void setInterest(double interest) {
    rate = interest;
  }
  
  public void deposit(double amount) {
    this.balance += amount;
  }
  
  public double getInterest(int years) {
    return this.balance * rate * years;
  }
  
  @Override
  public String toString () {
    return "ID" + this.id;
  }
  
}
