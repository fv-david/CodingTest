package fv.monster.repository;

import fv.monster.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author davidtobing -- fv.davidtobing@gmail.com
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}