package fit.iuh.edu.vn.backend.ids;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSkillId implements Serializable {
    private String jobId;  // Thêm trường jobId vào đây để ánh xạ với @MapsId("jobId")
    private String skillId; // Nếu bạn cần thêm skillId, hãy giữ lại nó

    // Hàm phát sinh ID
    public static JobSkillId generate(String jobId, String skillId) {
        return new JobSkillId(jobId, skillId);
    }
}
