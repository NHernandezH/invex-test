package com.invex.employees.infrastructure.rest;

import com.invex.employees.application.service.EmployeeSearchService;
import com.invex.employees.application.service.EmployeeStorageService;
import com.invex.employees.common.constants.EmployeeValidationMessage;
import com.invex.employees.domain.model.Employee;
import com.invex.employees.domain.model.Paging;
import com.invex.employees.infrastructure.rest.dto.EmployeeCreatedDto;
import com.invex.employees.infrastructure.rest.dto.EmployeeDto;
import com.invex.employees.infrastructure.rest.dto.EmployeesDto;
import com.invex.employees.infrastructure.rest.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeSearchService employeeSearchService;
    private final EmployeeStorageService employeeStorageService;
    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @GetMapping
    public ResponseEntity<List<EmployeeCreatedDto>> getAll(@RequestHeader(name = "page", defaultValue = "0") Integer page,
                                                 @RequestHeader(name = "size", defaultValue = "30") Integer size){
        Paging paging = new Paging(size, page);
        List<Employee> employees = employeeSearchService.all(paging);
        return ResponseEntity.ok(employeeMapper.toEmployeesCreatedDto(employees));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeCreatedDto> getById(@PathVariable("id") Long id){
        Employee employee = employeeSearchService.byId(id);
        return ResponseEntity.ok(employeeMapper.toEmployeesCreatedDto(employee));
    }
    @PostMapping
    public ResponseEntity<List<EmployeeCreatedDto>> saveAll(@RequestBody @Valid EmployeesDto employees){

        List<Employee> employeesCreated = employeeStorageService.saveAll(employeeMapper.toEmployees(employees.getEmployees()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeMapper.toEmployeesCreatedDto(employeesCreated));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id,
                                           @RequestBody @Valid EmployeeDto employeeDto){
        Employee employee = employeeMapper.toEmployee(employeeDto,id);

        employeeStorageService.update(employee);
        return ResponseEntity
                .noContent()
                .build();
    }
}
