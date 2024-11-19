package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "skill")
public class Skill {
    @Id
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Enumerated(EnumType.STRING)
    private SkillType skill_type;

    @OneToMany(mappedBy = "skill")
    private List<CandidateSkill> candidateSkills;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}