// Q2: Display all employees
    
    @GetMapping("/displayAll")
    public List<employee> getAllEmployees() {
        return repository.findAll();
    } 
