package fit.iuh.edu.vn.backend.models;

import fit.iuh.edu.vn.backend.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_desc")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_type")
    private SkillType type;

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