package fit.iuh.edu.vn.fontend.controller;

import fit.iuh.edu.vn.backend.services.SkillService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/list")
    public String listSkills(Model model) {
        model.addAttribute("skills", skillService.getAllSkills());
        return "skills/list-skills";
    }
}
