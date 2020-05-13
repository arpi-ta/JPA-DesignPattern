package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	@Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();
	// NOTE: HQL looks like SQL, instead of table, Java classes and it's
	// instance variables are addressed here
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	double getAverageSalary(@Param("id") int id);
	
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();
}
