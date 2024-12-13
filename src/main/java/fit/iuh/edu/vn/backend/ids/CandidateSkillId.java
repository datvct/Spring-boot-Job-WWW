package fit.iuh.edu.vn.backend.ids;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillId implements Serializable {
    private Long canId; // Đảm bảo tên trường khớp với @MapsId trong CandidateSkill
    private Long skillId;
}
