package fit.iuh.edu.vn.backend.services;

import fit.iuh.edu.vn.backend.models.Job;
import fit.iuh.edu.vn.backend.repositories.CompanyRepository;
import fit.iuh.edu.vn.backend.repositories.JobRepository;
import fit.iuh.edu.vn.backend.repositories.JobSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;


    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
}
