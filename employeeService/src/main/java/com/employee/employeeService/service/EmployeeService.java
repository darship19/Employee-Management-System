package com.employee.employeeService.service;
import java.util.*;
import com.employee.employeeService.dto.request.EmployeeCreateRequest;
import com.employee.employeeService.dto.response.EmployeeCreateResponse;
import com.employee.employeeService.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(EmployeeCreateRequest employeeCreateRequest);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);
    Employee updateEmployee(int id, EmployeeCreateRequest employeeCreateRequest);
    Employee patchEmployee(int id, EmployeeCreateRequest employeeCreateRequest);
    boolean deleteEmployee(int id);
}
