package com.employee.employeeService.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeCreateRequest {
    private String empNo;
    private String empName;
    private String empAddressLine1;
    private String empAddressLine2;
    private String empAddressLine3;
    private LocalDateTime empDateofJoin;
    private boolean empStatus;
    private String empImage;
}
