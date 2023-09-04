package springbootdemo.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootdemo.springbootcrudapi.model.Employee;
import springbootdemo.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeeService.get();
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		return employeeService.get(id);
	}

	@PostMapping("/employee")
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee with id " + id + " has been deleted!\n";
	}
	
	@PutMapping("/update/employee")
	public String update(@RequestBody Employee employee) {
		
		employeeService.update(employee);
		return "Employee with id " + employee.getId() + " has been updated!\n";
	}
}
