package com.example.crud.controller;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/")
    public String welcome(){
        return "Welcome to my Springboot project";
    }
    @GetMapping("/getall")
    public List<Employee> getAll(){
        return this.employeeService.getAll();
    }
    @GetMapping("/getall/{id}")
    public Employee getAll(@PathVariable long id){
        return this.employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateById(@RequestBody Employee employee, @PathVariable long id){
        return this.employeeService.update(employee,id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable long id){
        try {
            this.employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
