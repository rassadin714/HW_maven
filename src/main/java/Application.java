import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
        Scanner scanner = new Scanner(System.in);


        List<Employee> employees = List.of(new Employee("Дмитрий", "Дмитриев", "муж", 19),
                new Employee("Алина", "Алинова", "жен", 20));
        City city = new City( "Самара", employees);
        cityDAO.createCity(city);

        System.out.println("Введите id города для изменения в базе");
        int id = scanner.nextInt();
        System.out.println("Какого сотрудника будем изменять? Введите id:");
        int idEmpl = scanner.nextInt();

        Employee employeeCity = employeeDAO.getEmployeeById(idEmpl);
        Employee employee1 = enterInformationWithScanner();
        employee1.setId(employeeCity.getId());
        cityDAO.updateCityById(id, employee1);


        System.out.println("Введите id города для удаления в базе");
        id = scanner.nextInt();
        City city11 = cityDAO.getCityById(id);
        cityDAO.deleteCityById(city11);

        System.out.println("Все сотрудники");
        List<Employee> employees1 = employeeDAO.getAllEmployees();
        employees1.stream()
                .forEach(System.out::println);


        List<City> cities = cityDAO.getAllCities();
        cities.stream()
                .forEach(System.out::println);

        HibernateUtil.closeEntityManagerFactory();


    }
    public static Employee enterInformationWithScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя");
        String first_name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String last_name = scanner.nextLine();
        System.out.println("Введите пол");
        String gender = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = scanner.nextInt();
        Employee employee = new Employee(first_name, last_name, gender,age);
        return employee;
    }
}