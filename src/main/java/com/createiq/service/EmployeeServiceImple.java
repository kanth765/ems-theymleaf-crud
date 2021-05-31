package com.createiq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;

@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("employee not found with this id: " + id);
		}
		return employee;
	}

	@Override
	public void delete(int id) {
		this.employeeRepository.deleteById(id);
	}

}
