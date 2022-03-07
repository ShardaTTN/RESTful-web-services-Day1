package com.tothenew.sharda.EmployeeStuff;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	@GetMapping(path = "/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = employeeService.findOne(id);
		if(employee == null) {
			throw new EmployeeNotFoundException("No Employee found with ID: "+id);
		}
		return employeeService.findOne(id);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> createUser(@Validated @RequestBody Employee employee) {
		Employee createdEmployee = employeeService.save(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEmployee.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		Employee employee = employeeService.deleteById(id);
		if(employee == null) {
			throw new EmployeeNotFoundException("No Employee found with ID: "+id);
		}
	}
	
	@PutMapping(path = "/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		employeeService.updateById(id, employee);
	}
}