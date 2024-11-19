package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.services;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models.Job;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }
}
