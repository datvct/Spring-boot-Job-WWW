package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "job_skill")
public class JobSkill {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @MapsId("skillId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

}