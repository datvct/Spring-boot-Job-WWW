package fit.iuh.edu.vn.vancongthanhdat_21117961_btl.services;

import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.models.Skill;
import fit.iuh.edu.vn.vancongthanhdat_21117961_btl.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}
