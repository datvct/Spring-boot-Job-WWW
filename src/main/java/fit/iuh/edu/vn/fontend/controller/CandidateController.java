package fit.iuh.edu.vn.fontend.controller;

import fit.iuh.edu.vn.backend.services.CandidateService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/list")
    public String listCandidates(Model model) {
        model.addAttribute("candidates", candidateService.findAll());
        return "candidates/list-candidates";
    }
}
