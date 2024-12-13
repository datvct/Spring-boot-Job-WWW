package fit.iuh.edu.vn.backend.repositories;

import fit.iuh.edu.vn.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
