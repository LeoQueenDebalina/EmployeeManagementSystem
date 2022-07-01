package com.example.crud.service;

import com.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(long id);
    public Employee update(Employee employee, long id);
    public void delete(long id);
}
