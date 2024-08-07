package com.teccience.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer id;
    @NotBlank(message = "employee name shouldn't be blank or null")
    private String name;
    @NotNull(message = "department id shouldn't be null")
    @Positive(message = "department id should be positive number")
    private Integer departmentId;
    @NotNull(message = "manager id shouldn't be null")
    @Positive(message = "manager id should be positive number")
    private Integer managerId;
    @NotNull(message = "employee registration date shouldn't be null")
    private LocalDate date;
}
