package com.kgonzaga.soap_client.app;

import com.kgonzaga.soap_client.app.persistence.wsdl.Employee;
import com.kgonzaga.soap_client.app.presentation.client.EmployeeClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
    }

    private static void listEmployee(Employee employee) {
        var message = String.format("Employee => { id = %d, name = %s, job =  %s, salary = %.2f}",
                employee.getId(), employee.getName(), employee.getJob(), employee.getSalary());
        System.out.println(message);
    }

    @Bean
    CommandLineRunner lookup(EmployeeClient client) {
        return args -> {
            list(client);
            var employe = new Employee();
            employe.setName("Jose");
            employe.setJob("Carpintero");
            employe.setSalary(new BigDecimal(500));

            create(client, employe);
            list(client);
            getOn(client, 1L);

            employe.setName("Jose Update");
            update(client, 5L, employe);
            list(client);
            delete(client, 5L);
            list(client);
        };
    }

    private void list(EmployeeClient client) {
        var list = client.getAllEmployeesResponse().getEmployees();
        list.forEach(SoapClientApplication::listEmployee);
    }

    private void create(EmployeeClient client, Employee employee) {
        var employeeResponse = client.createEmployeeResponse(employee).getEmployee();
        listEmployee(employeeResponse);
    }

    private void getOn(EmployeeClient client, Long id) {
        var employeeResponse = client.getEmployeeResponse(id).getEmployee();
        listEmployee(employeeResponse);
    }

    private void update(EmployeeClient client, Long id, Employee employee) {
        var employeeResponse = client.updateEmployeeResponse(id, employee).getEmployee();
        listEmployee(employeeResponse);
    }

    private void delete(EmployeeClient client, Long id) {
        var response = client.deleteEmployeeResponse(id).isSuccess();
        System.out.println(response);
    }


}
