package defining_classes.exercises.company_rooster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    int employeeCnt = Integer.parseInt(reader.readLine());
    Employee employee = null;
    
    Map<String, Department> departments = new HashMap<>();
    while (employeeCnt-- > 0) {
      String[] inTokens = reader.readLine().split(" ");
      int inTokensLength = inTokens.length;
      String name = inTokens[0];
      double salary = Double.parseDouble(inTokens[1]);
      String position = inTokens[2];
      String departmentName = inTokens[3];
  
  
      employee = new Employee(name, salary, position, departmentName);
      Department department = new Department(departmentName);
      
      departments.putIfAbsent(departmentName, department);
      
      switch (inTokensLength) {
        case 5:
          try {
            int age = Integer.parseInt(inTokens[4]);
            employee.setAge(age);
          } catch (Exception e) {
            String email = inTokens[4];
            employee.setEmail(email);
          }
          break;
        case 6:
          String email = inTokens[4];
          int age = Integer.parseInt(inTokens[5]);
          employee.setEmail(email);
          employee.setAge(age);
          break;
      }
      
      departments.get(departmentName).addEmployee(employee);
      
    }
  
    departments.entrySet().stream()
            .sorted((d1, d2) -> Double.compare(
                    d2.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                    d1.getValue().getEmployees().stream().mapToDouble(Employee::getSalary).average().getAsDouble()
            )).limit(1)
            .forEach(d -> {
              System.out.println(String.format("Highest Average Salary: %s", d.getKey()));
              d.getValue().getEmployees().stream()
                      .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList())
                      .forEach(System.out::println);
            });
    
  }
}
