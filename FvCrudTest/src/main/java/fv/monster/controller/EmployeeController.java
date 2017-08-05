package fv.monster.controller;

import fv.monster.model.Employee;
import fv.monster.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author davidtobing -- fv.davidtobing@gmail.com
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    // save new employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
            final RedirectAttributes redirectAttributes) {

        if (employeeService.saveEmployee(employee) != null) {
            redirectAttributes.addFlashAttribute("saveEmployee", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveEmployee", "unsuccess");
        }

        return "redirect:/";
    }

    // edit and delete employee
    @RequestMapping(value = "/{operation}/{empId}", method = RequestMethod.GET)
    public String editRemoveEmployee(@PathVariable("operation") String operation,
            @PathVariable("empId") Long empId, final RedirectAttributes redirectAttributes,
            Model model) {
        
        if (operation.equals("delete")) {
            if (employeeService.deleteEmployee(empId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            Employee editEmployee = employeeService.findEmployee(empId);
            if (editEmployee != null) {
                model.addAttribute("editEmployee", editEmployee);
                return "editPage";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/";
    }

    // update employee
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("editEmployee") Employee editEmployee,
            final RedirectAttributes redirectAttributes) {
        if (employeeService.editEmployee(editEmployee) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/";
    }
}
