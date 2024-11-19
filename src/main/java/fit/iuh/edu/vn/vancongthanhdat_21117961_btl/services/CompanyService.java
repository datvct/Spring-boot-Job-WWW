package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.services;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models.Company;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
}
