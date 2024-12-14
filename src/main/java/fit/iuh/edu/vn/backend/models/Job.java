package fit.iuh.edu.vn.backend.models;

import fit.iuh.edu.vn.backend.enums.StatusJob;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;

    @Column(name = "status", nullable = false)
    private StatusJob status;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Job(String jobDesc, String jobName, Company company, List<JobSkill> jobSkills, StatusJob status) {
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
        this.jobSkills = jobSkills;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobDesc='" + jobDesc + '\'' +
                ", jobName='" + jobName + '\'' +
                ", company=" + company +
                ", jobSkills=" + jobSkills +
                ", status=" + status +
                '}';
    }
}