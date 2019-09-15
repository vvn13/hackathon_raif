package com.orange.freelance_rfb.api.controller;

import com.orange.freelance_rfb.model.dto.JobCreatorDto;
import com.orange.freelance_rfb.service.JobService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping("/create")
    public void create(@RequestBody JobCreatorDto job, HttpServletResponse response) {
        jobService.createJob(job.getLogin(), job.getDescription(), job.getPrice());
    }

    @RequestMapping("/findall")
    public List<JobCreatorDto> findAll() {
        return jobService.findAll();
    }
}
