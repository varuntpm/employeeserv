package com.paypal.bfs.test.employeeserv.impl;

import java.util.HashSet;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.entities.Employee;
import com.paypal.bfs.test.employeeserv.entities.EmployeeServiceResponse;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;




@RestController
public class EmployeeResourceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static HashSet<Integer> employeeCache = new HashSet<>();

	
	@GetMapping("/v1/bfs/employees/{id}")
	public ResponseEntity<Object> employeeGetById(@PathVariable("id") String id) {
		try {
			Employee emp = employeeRepository.findById(Integer.valueOf(id)).get();
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (NoSuchElementException exp) {
			EmployeeServiceResponse response = new EmployeeServiceResponse(
					"No employee with given id exists in database" + exp.getMessage(), HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	
	@PostMapping("/v1/bfs/employees")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
		EmployeeServiceResponse response = null;
		HttpStatus status = null;

		int employeeHashKey = employee.hashCode();

		if (employeeCache.contains(employeeHashKey)) {
			status = HttpStatus.OK;
			response = new EmployeeServiceResponse(
					"Employee already exists in the database", status);
		} else {
			try {
				employeeRepository.save(employee);
				status = HttpStatus.CREATED;
				response = new EmployeeServiceResponse("Employee Created Successfully with id - " + employee.getId(),
						HttpStatus.CREATED);
				employeeCache.add(employeeHashKey);
			} catch (Exception exp) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				response = new EmployeeServiceResponse("Exception during employee creation - " + exp.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<>(response, status);
	}


	

}