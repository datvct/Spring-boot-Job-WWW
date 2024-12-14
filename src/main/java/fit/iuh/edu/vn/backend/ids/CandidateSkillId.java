package fit.iuh.edu.vn.backend.ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkillId implements Serializable {
    @Column(name = "can_id", nullable = false)
    private Long canId;

    @Column(name = "skill_id", nullable = false)
    private Long skillId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkillId that = (CandidateSkillId) o;
        return Objects.equals(canId, that.canId) && Objects.equals(skillId, that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canId, skillId);
    }
}
