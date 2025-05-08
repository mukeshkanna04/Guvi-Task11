package task11.controller;

import task11.model.Employee;
import task11.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

    @Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository repo;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        repo.save(employee);
        return "redirect:/employee/displayAll";
    }

    @GetMapping("/employee/displayAll")
    @ResponseBody
    public List<Employee> displayAll() {
        return repo.findAll();
    }

    @GetMapping("/employee/display/{id}")
    @ResponseBody
    public Optional<Employee> displayById(@PathVariable String id) {
        return repo.findById(id);
    }
}
