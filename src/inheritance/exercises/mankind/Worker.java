package inheritance.exercises.mankind;

public class Worker extends Human{
  private final static int MIN_WORKER_LAST_NAME_LENGTH = 4;
  private final static double MIN_WOKR_HOURS_PER_DAY = 1.0d;
  private final static double  MAX_WORK_HOURS_PER_DAY = 12.0d;
  
  private double weekSalary;
  private double workHoursPerDay;
  private double salaryPerHour;
  
  
  public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
    super(firstName, lastName);
    this.setWeekSalary(weekSalary);
    this.setWorkHoursPerDay(workHoursPerDay);
    this.setSalaryPerHour();
  }
  
  @Override
  protected void setLastName(String lastName) {
    if (checkNameLength(lastName, MIN_WORKER_LAST_NAME_LENGTH)) {
      super.setLastName(lastName);
    } else {
      throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
    }
  }
  
  private void setWeekSalary(double weekSalary) {
    if (weekSalary >= 10) {
      this.weekSalary = weekSalary;
    } else {
      throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
    }
  }
  
  private void setWorkHoursPerDay(double workHoursPerDay) {
    if (workHoursPerDay > MIN_WOKR_HOURS_PER_DAY
            && workHoursPerDay < MAX_WORK_HOURS_PER_DAY) {
      this.workHoursPerDay = workHoursPerDay;
    } else {
      throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
    }
  }
  
  private void setSalaryPerHour() {
    this.salaryPerHour = (this.weekSalary / 7) / 10;
  }
  
  private double getWeekSalary() {
    return this.weekSalary;
  }
  
  private double getWorkHoursPerDay() {
    return this.workHoursPerDay;
  }
  
  private double getSalaryPerHour() {
    return this.salaryPerHour;
  }
  
  @Override
  public String toString() {
    return String.format("First Name: %s\n" +
                         "Last Name: %s\n" +
                         "Week Salary: %.2f\n" +
                         "Hours per day: %.2f\n" +
                         "Salary per hour: %.2f\n"
    ,this.getFirstName(), this.getLastName(), this.getWeekSalary(), this.getWorkHoursPerDay(),
            this.getSalaryPerHour());
  }
}
