package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "exprience")
public class Experience {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company", length = 120)
    private String companyName;

    @Column(name="role", length = 100)
    private String role;

    @Column(name="work_desc",length = 400)
    private String workDescription;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate")
    private Candidate candidate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
