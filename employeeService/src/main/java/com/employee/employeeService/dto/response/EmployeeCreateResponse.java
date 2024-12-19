package com.employee.employeeService.dto.response;

import com.employee.employeeService.model.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class EmployeeCreateResponse{
    private String message;
    private  ResponseCreateEmployee data;

    public EmployeeCreateResponse(String message, Employee employee){
        this.message=message;
        this.data=new ResponseCreateEmployee(employee);
    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class ResponseCreateEmployee {
    private int id;
    private String empNo;
    private String empName;
    private String empAddressLine1;
    private String empAddressLine2;
    private String empAddressLine3;
    private LocalDateTime empDateofJoin;
    private boolean empStatus;
    private String empImage;

    public ResponseCreateEmployee(Employee employee) {
        this.id = employee.getId();
        this.empNo = employee.getEmpNo();
        this.empName = employee.getEmpName();
        this.empAddressLine1 = employee.getEmpAddressLine1();
        this.empAddressLine2 = employee.getEmpAddressLine2();
        this.empAddressLine3 = employee.getEmpAddressLine3();
        this.empDateofJoin = employee.getEmpDateofJoin();
        this.empStatus = employee.isEmpStatus();
        this.empImage = employee.getEmpImage();
    }
}
