package fit.iuh.edu.vn.backend.enums;

public enum SkillLevel {
    BEGINNER(1),
    INTERMEDIATE(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    MASTER(5);
    private final int level;

    SkillLevel(int level) {
        this.level = level;
    }

    // Getter để lấy giá trị level
    public int getLevel() {
        return level;
    }
}
