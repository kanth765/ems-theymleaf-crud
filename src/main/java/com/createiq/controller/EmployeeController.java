package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.createiq.entity.Employee;
import com.createiq.service.EmployeeServiceImple;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImple employeeServiceImple;

	@GetMapping("/")
	public String viewAllEmployees(Model map) {
		map.addAttribute("listEmployees", employeeServiceImple.getAll());
		return "index";
	}

	@RequestMapping(value = "/shownewForm", method = RequestMethod.GET)
	public String showview(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeServiceImple.save(employee);
		return "redirect:/";
	}

	@GetMapping("/updates/{id}")
	public String updateEmp(@PathVariable(value = "id") int id, Model model) {
		Employee employee = employeeServiceImple.getById(id);
		model.addAttribute("employee", employee);
		return "update_emp";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value = "id") int id) {
		this.employeeServiceImple.delete(id);
		return "redirect:/";
	}

}
