package fit.iuh.edu.vn.fontend.controller;


import fit.iuh.edu.vn.backend.enums.SkillLevel;
import fit.iuh.edu.vn.backend.models.Company;
import fit.iuh.edu.vn.backend.models.Job;
import fit.iuh.edu.vn.backend.models.JobSkill;
import fit.iuh.edu.vn.backend.models.Skill;
import fit.iuh.edu.vn.backend.repositories.CompanyRepository;
import fit.iuh.edu.vn.backend.repositories.JobRepository;
import fit.iuh.edu.vn.backend.repositories.SkillRepository;
import fit.iuh.edu.vn.backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller

public class JobController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CompanyRepository companyRepository;


    @GetMapping("/danh-sach-tuyen-dung")
    public String listJobs(Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        // Pagination with sorting
        Page<Job> jobPage = jobRepository.findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by("id").ascending()));

        // Add paginated job page to the model
        model.addAttribute("jobPage", jobPage);
        model.addAttribute("jobs", jobPage.getContent());

        int totalPages = jobPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<>();

            if (totalPages > 10) {
                pageNumbers.add(1);
                if (currentPage > 5) {
                    pageNumbers.add(-1); // for "..." indication
                }
            }

            for (int i = Math.max(1, currentPage - 2); i <= Math.min(totalPages, currentPage + 2); i++) {
                pageNumbers.add(i);
            }

            if (totalPages - currentPage > 5) {
                pageNumbers.add(-1); // for "..." indication
                pageNumbers.add(totalPages);
            }

            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "jobs/list-jobs";
    }

    @PostMapping("/post-job")
    public String postJob(@RequestParam("jobName") String jobName,
                          @RequestParam("jobDesc") String jobDesc,
                          @RequestParam("skills") String skills,
                          @RequestParam("companyId") Long companyId) {

        // Chuyển đổi skills từ chuỗi thành List<Long>
        List<Long> skillIds = Arrays.stream(skills.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());

        // Tìm công ty theo ID
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isEmpty()) {
            return "redirect:/error"; // Xử lý khi không tìm thấy công ty
        }

        // Tạo và lưu Job mới
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobDesc(jobDesc);
        job.setCompany(companyOptional.get());

        Job savedJob = jobRepository.save(job);

        // Lưu các kỹ năng liên quan
        for (Long skillId : skillIds) {
            Optional<Skill> skillOptional = skillRepository.findById(skillId);
            skillOptional.ifPresent(skill -> {
                JobSkill jobSkill = new JobSkill();
                jobSkill.setJob(savedJob);
                jobSkill.setSkill(skill);
                jobSkill.setSkillLevel(SkillLevel.BEGINNER);
                jobSkill.setMoreInfos("");

                savedJob.getJobSkills().add(jobSkill);
            });
        }

        jobRepository.save(savedJob);

        return "redirect:/danh-sach-tuyen-dung";
    }



}
