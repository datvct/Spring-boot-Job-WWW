package fit.iuh.edu.vn.backend.repositories;

import fit.iuh.edu.vn.backend.ids.JobSkillId;
import fit.iuh.edu.vn.backend.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {
}
