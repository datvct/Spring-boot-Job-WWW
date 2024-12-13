package fit.iuh.edu.vn.fontend.controller;


import fit.iuh.edu.vn.backend.models.Job;
import fit.iuh.edu.vn.backend.models.JobSkill;
import fit.iuh.edu.vn.backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/post")
    public String showJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "jobs/post-job";
    }

    @PostMapping("/post")
    public String postJob(@ModelAttribute Job job, @RequestParam String[] skills) {
        job.setJobSkills(Arrays.stream(skills)
                .map(skillName -> new JobSkill(null, skillName, job))
                .toList());
        jobService.saveJob(job);
        return "redirect:/jobs/list";
    }

    @GetMapping("/list")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobService.findAllJobs());
        return "jobs/list-jobs";
    }
}
