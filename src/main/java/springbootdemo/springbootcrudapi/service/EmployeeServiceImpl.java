package springbootdemo.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springbootdemo.springbootcrudapi.dao.EmployeeDAO;
import springbootdemo.springbootcrudapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Transactional
	@Override
	public List<Employee> get() {
      return employeeDAO.get();
	}
	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}
	@Transactional
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
		return;
	}
	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
		return;
	}
	@Transactional
	@Override
	public void update(Employee employee) {
		Employee emp = employeeDAO.get(employee.getId());
		emp.setName(employee.getName());
		emp.setDob(employee.getDob());
		emp.setDepartment(employee.getDepartment());
		emp.setGender(employee.getGender());
		employeeDAO.save(emp);
		return;
	}

}
