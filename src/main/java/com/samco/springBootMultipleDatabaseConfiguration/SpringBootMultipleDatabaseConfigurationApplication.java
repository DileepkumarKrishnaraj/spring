package com.samco.springBootMultipleDatabaseConfiguration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samco.springBootMultipleDatabaseConfiguration.primary.employee.Employee;
import com.samco.springBootMultipleDatabaseConfiguration.primaryRepository.employee.EmployeeRepository;
import com.samco.springBootMultipleDatabaseConfiguration.secondary.manager.Manager;
import com.samco.springBootMultipleDatabaseConfiguration.secondaryRepository.manager.ManagerRepository;

@SpringBootApplication
@RestController
public class SpringBootMultipleDatabaseConfigurationApplication {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ManagerRepository managerRepository;
	
	@PostMapping
	public void saveData() {
		employeeRepository.saveAll(Stream.of(new Employee("Dileepkumar", "dileep76@gmail.com", 10000), new Employee("Kalaiselvan", "kalai8@gmail.com", 13000), new Employee("Nitheeshkumar", "nitheesh54@gmail.com", 15000), new Employee("Yamini", "yamini34@gmail.com", 20000)).collect(Collectors.toList()));
		managerRepository.saveAll(Stream.of(new Manager("Geetha", "geetha3@gmail.com",200000)).collect(Collectors.toList()));
	}
	
	@GetMapping("/getUsers")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/getManager")
	public List<Manager> getManager() {
		return managerRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDatabaseConfigurationApplication.class, args);
	}

}
