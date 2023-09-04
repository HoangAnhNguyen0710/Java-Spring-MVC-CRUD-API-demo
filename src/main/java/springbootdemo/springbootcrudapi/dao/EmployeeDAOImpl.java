package springbootdemo.springbootcrudapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import springbootdemo.springbootcrudapi.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<Employee> get() {
		Session currentSession= entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee E Where E.id = :employee_id", Employee.class);
		query.setParameter("employee_id", id);
		List<Employee> result = query.getResultList();
		return result.get(0);
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(employee);
		return;
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.find(Employee.class, id);
		currentSession.remove(employee);
		System.out.println("removed !");
		return;
	}
}
