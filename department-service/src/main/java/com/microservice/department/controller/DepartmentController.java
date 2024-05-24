package com.microservice.department.controller;


import com.microservice.department.entity.Department;
import com.microservice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Value("${eureka.client.service-url.defaultZone}") String eurekaServerName;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDept")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/getDept/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/getAllDepts")
    public List<Department> findAllDepartments() {
        log.info("Inside findDepartmentById method of DepartmentController");
        System.out.println(eurekaServerName);
        return departmentService.getALlDeptList();
    }

}
