package com.employee.employeeService.controller;

import com.employee.employeeService.Repository.EmployeeRepository;
import com.employee.employeeService.dto.request.EmployeeCreateRequest;
import com.employee.employeeService.dto.response.EmployeeCreateResponse;
import com.employee.employeeService.model.Employee;
import com.employee.employeeService.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Operation(summary = "Create a new employee", description = "Add a new employee to the system")
    @PostMapping()
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeCreateRequest employee) {
        try {
            log.info("Headers: {}", employee);
            Employee savedEmployee = employeeService.saveEmployee(employee);
            log.info("Saved Employee: {}", savedEmployee);
            String message = "Employee added successfully";
            EmployeeCreateResponse response = new EmployeeCreateResponse(message, savedEmployee);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while saving employee: {}", e.getMessage(), e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
   @GetMapping(produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
          log.info("Retrieved all employees: {}", employees);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while retrieving employees: {}", e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Get employee by ID", description = "Retrieve an employee by their ID")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            log.info("Retrieved employee with ID {}: {}", id, employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while retrieving employee with ID {}: {}", id, e.getMessage(), e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update the employee", description = "Update the entire employee record")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeCreateRequest employeeRequest) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
            log.info("Updated Employee with ID {}: {}", id, updatedEmployee);
            String message = "Employee updated successfully";
            EmployeeCreateResponse response = new EmployeeCreateResponse(message, updatedEmployee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while updating employee with ID {}: {}", id, e.getMessage(), e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update the employee", description = "Update specific attributes of an employee")
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> patchEmployee(@PathVariable("id") int id, @RequestBody EmployeeCreateRequest employeeRequest) {
        try {
            Employee patchedEmployee = employeeService.patchEmployee(id, employeeRequest);
            log.info("Patched Employee with ID {}: {}", id, patchedEmployee);
            String message = "Employee updated successfully";
            EmployeeCreateResponse response = new EmployeeCreateResponse(message, patchedEmployee);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while patching employee with ID {}: {}", id, e.getMessage(), e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete the  employee", description = "Delete the employee by id")
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {
        try {
            boolean isDeleted = employeeService.deleteEmployee(id);
            if (isDeleted) {
                log.info("Employee with ID {} deleted successfully.", id);
                return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
            } else {
                log.error("Employee with ID {} not found.", id);
                return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting employee with ID {}: {}", id, e.getMessage(), e);
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
