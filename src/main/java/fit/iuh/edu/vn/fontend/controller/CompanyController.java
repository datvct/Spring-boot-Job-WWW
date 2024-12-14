package fit.iuh.edu.vn.fontend.controller;

import fit.iuh.edu.vn.backend.repositories.CompanyRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CompanyController {

    private final CompanyRepository companyRepository;


    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/list")
    public String listCompany(Model model) {
        model.addAttribute("company", companyRepository.findAll());
        return "company/list-jobs";
    }
}
