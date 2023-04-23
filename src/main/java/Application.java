import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Scanner scanner = new Scanner(System.in);


        employeeDAO.createEmployee(new Employee("Дмитрий", "Дмитриев", "муж", 40, 6));



        System.out.println("Введите id сотрудника для поиска в базе");
        int id = scanner.nextInt();
        Employee employee = employeeDAO.getEmployeeById(id);
        System.out.println(employee);


        System.out.println("Все сотрудники");
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee emp: employees){
            System.out.println(emp);
        }

        System.out.println("Введите id сотрудника для изменения в базе");
        id = scanner.nextInt();
        employeeDAO.updateEmployeeById(id);


        System.out.println("Введите id сотрудника для удаления в базе");
        id = scanner.nextInt();
        employeeDAO.deleteEmployeeById(id);

    }
}