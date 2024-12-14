package fit.iuh.edu.vn.backend.repositories;

import fit.iuh.edu.vn.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long>{
    @Query("SELECT j FROM Job j LEFT JOIN FETCH j.jobSkills js LEFT JOIN FETCH js.skill")
    List<Job> findAllWithJobSkills();
}
