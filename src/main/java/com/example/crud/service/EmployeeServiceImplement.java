package com.example.crud.service;
import com.example.crud.entity.Employee;
import com.example.crud.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
    private RepositoryEmployee repositoryEmployee;
    @Override
    public List<Employee> getAll() {
        return repositoryEmployee.findAll();
    }
    @Override
    public Employee getById(long id) {
        Optional<Employee> data = repositoryEmployee.findById(id);
        if (data.isPresent()){
            return data.get();
        }
        return null;
    }
    @Override

    public Employee update(Employee employee,long id) {
        Optional<Employee> data = repositoryEmployee.findById(id);
        if(data.isPresent()) {
            employee.setId(id);
            return repositoryEmployee.save(employee);
        } else{
            return null;
        }
    }
    @Override
    public void delete(long id){

        repositoryEmployee.deleteById(id);


    }
}
