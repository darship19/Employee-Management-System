package com.employee.employeeService.service.Impls;

import com.employee.employeeService.Repository.EmployeeRepository;
import com.employee.employeeService.dto.request.EmployeeCreateRequest;
import com.employee.employeeService.model.Employee;
import com.employee.employeeService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(EmployeeCreateRequest employeeCreateRequest){
        Employee employee =Employee.builder()
                .empNo(employeeCreateRequest.getEmpNo())
                .empName(employeeCreateRequest.getEmpName())
                .empAddressLine1(employeeCreateRequest.getEmpAddressLine1())
                .empAddressLine2(employeeCreateRequest.getEmpAddressLine2())
                .empAddressLine3(employeeCreateRequest.getEmpAddressLine3())
                .empDateofJoin(employeeCreateRequest.getEmpDateofJoin())
                .empStatus(employeeCreateRequest.isEmpStatus())
                .empImage(employeeCreateRequest.getEmpImage())
                .build();
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));  // Handle employee not found
    }
    @Override
    public Employee updateEmployee(int id, EmployeeCreateRequest employeeCreateRequest) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        existingEmployee.setEmpNo(employeeCreateRequest.getEmpNo());
        existingEmployee.setEmpName(employeeCreateRequest.getEmpName());
        existingEmployee.setEmpAddressLine1(employeeCreateRequest.getEmpAddressLine1());
        existingEmployee.setEmpAddressLine2(employeeCreateRequest.getEmpAddressLine2());
        existingEmployee.setEmpAddressLine3(employeeCreateRequest.getEmpAddressLine3());
        existingEmployee.setEmpDateofJoin(employeeCreateRequest.getEmpDateofJoin());
        existingEmployee.setEmpStatus(employeeCreateRequest.isEmpStatus());
        existingEmployee.setEmpImage(employeeCreateRequest.getEmpImage());

        return employeeRepository.save(existingEmployee);
    }
    @Override
    public Employee patchEmployee(int id, EmployeeCreateRequest employeeCreateRequest) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        if (employeeCreateRequest.getEmpNo() != null) {
            existingEmployee.setEmpNo(employeeCreateRequest.getEmpNo());
        }
        if (employeeCreateRequest.getEmpName() != null) {
            existingEmployee.setEmpName(employeeCreateRequest.getEmpName());
        }
        if (employeeCreateRequest.getEmpAddressLine1() != null) {
            existingEmployee.setEmpAddressLine1(employeeCreateRequest.getEmpAddressLine1());
        }
        if (employeeCreateRequest.getEmpAddressLine2() != null) {
            existingEmployee.setEmpAddressLine2(employeeCreateRequest.getEmpAddressLine2());
        }
        if (employeeCreateRequest.getEmpAddressLine3() != null) {
            existingEmployee.setEmpAddressLine3(employeeCreateRequest.getEmpAddressLine3());
        }
        if (employeeCreateRequest.getEmpDateofJoin() != null) {
            existingEmployee.setEmpDateofJoin(employeeCreateRequest.getEmpDateofJoin());
        }
        if (employeeCreateRequest.getEmpImage() != null) {
            existingEmployee.setEmpImage(employeeCreateRequest.getEmpImage());
        }
        if (employeeCreateRequest.isEmpStatus() != existingEmployee.isEmpStatus()) {
            existingEmployee.setEmpStatus(employeeCreateRequest.isEmpStatus());
        }

        return employeeRepository.save(existingEmployee);
    }
    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
