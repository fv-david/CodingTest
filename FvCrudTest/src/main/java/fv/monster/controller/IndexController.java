package fv.monster.controller;

import fv.monster.model.Employee;
import fv.monster.service.EmployeeService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author davidtobing -- fv.davidtobing@gmail.com
 */
@Controller
public class IndexController {
    
    @Autowired
    EmployeeService employeeService;
    
    // index page / list employee
    @GetMapping("/")
    public String savePage(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("allEmployees", (ArrayList<Employee>) employeeService.getAllEmployees());
        return "index";
    }

}