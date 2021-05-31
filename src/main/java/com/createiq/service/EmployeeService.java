package com.createiq.service;

import java.util.List;

import com.createiq.entity.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAll();
	
	Employee getById(int id);
	
	void delete(int id);

}
