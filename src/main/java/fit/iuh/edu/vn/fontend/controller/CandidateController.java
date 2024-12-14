package fit.iuh.edu.vn.fontend.controller;

import fit.iuh.edu.vn.backend.models.Candidate;
import fit.iuh.edu.vn.backend.repositories.CandidateRepository;
import fit.iuh.edu.vn.backend.repositories.ExperienceRepository;
import fit.iuh.edu.vn.backend.services.CandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateServices candidateServices;


    @GetMapping("/list")
    public String listCandidates(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateServices.getListPage(
                currentPage - 1, pageSize, "id", "asc");

        model.addAttribute("candidatePage", candidatePage);

        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<>();

            if (totalPages > 10) {
                pageNumbers.add(1);
                if (currentPage > 5) {
                    pageNumbers.add(-1);
                }
            }

            for (int i = Math.max(1, currentPage - 2); i <= Math.min(totalPages, currentPage + 2); i++) {
                if (i != 0) {
                    pageNumbers.add(i);
                }
            }

            if (totalPages - currentPage > 5) {
                pageNumbers.add(-1);
                pageNumbers.add(totalPages);
            }

            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }


}
