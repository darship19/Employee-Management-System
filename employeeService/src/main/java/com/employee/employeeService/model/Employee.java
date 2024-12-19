package com.employee.employeeService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false,name="emp_no")
    private String empNo;
    @Column(nullable = false,name="emp_name")
    private String empName;
    @Column(nullable = false,name="emp_address_line_1")
    private String empAddressLine1;
    @Column(name="emp_address_line_2")
    private String empAddressLine2;
    @Column(name="emp_address_line_3")
    private String empAddressLine3;
    @Column(nullable = false,name="emp_date_of_join")
    private LocalDateTime empDateofJoin;
    @Column(nullable = false)
    private boolean empStatus;
    @Column(nullable = false, name="emp_image")
    private String empImage;

}
