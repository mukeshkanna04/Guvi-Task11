// Q3: Display one employee by ID

@GetMapping("/display/{id}")
public Optional<Employee> getEmployeeById(@PathVariable String id) {
    return repository.findById(id);
}
