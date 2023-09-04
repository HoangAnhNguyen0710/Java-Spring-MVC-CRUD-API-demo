package springbootdemo.springbootcrudapi.service;

import java.util.List;

import springbootdemo.springbootcrudapi.model.Employee;

public interface EmployeeService {
	
    List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
	void update(final Employee employee);
}
