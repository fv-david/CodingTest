package fv.monster.service;

import fv.monster.model.Employee;
import java.util.Collection;

/**
 *
 * @author davidtobing -- fv.davidtobing@gmail.com
 */
public interface EmployeeService {

    public Employee saveEmployee(Employee emp);

    public Boolean deleteEmployee(Long empId);

    public Employee editEmployee(Employee emp);

    public Employee findEmployee(Long empId);

    public Collection<Employee> getAllEmployees();

}
