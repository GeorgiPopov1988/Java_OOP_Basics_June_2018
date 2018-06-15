package defining_classes.lab.bank_account;

public class BankAccount {
  private final static  double DEFAULT_INTEREST = 0.02;
  
  private int id;
  private double balance;
  
  public BankAccount(int id) {
    this.id = id;
    this.balance = 0;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public void deposit(double amount) {
    // if (amount < 0) {
    //   throw new IllegalArgumentException("iae");
    // }
    this.balance += amount;
  }
  
  public void withdraw(double amount) {
    // if (amount > this.balance) {
    //   throw new IllegalArgumentException();
    // }
    this.balance -= amount;
  }
  
  @Override
  public String toString() {
    return String.format("Account ID%d, balance %.2f", this.id, this.getBalance());
  }
  
  
}
