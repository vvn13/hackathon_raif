package com.orange.freelance_rfb.service;

import com.orange.freelance_rfb.model.dto.JobCreatorDto;
import com.orange.freelance_rfb.model.entity.Job;
import com.orange.freelance_rfb.model.enums.JobStatus;
import com.orange.freelance_rfb.model.enums.TransactionStatus;
import com.orange.freelance_rfb.repository.AccountRepository;
import com.orange.freelance_rfb.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private final AccountRepository accountRepository;
    private final JobRepository jobRepository;

    public JobService(AccountRepository accountRepository, JobRepository jobRepository) {
        this.accountRepository = accountRepository;
        this.jobRepository = jobRepository;
    }

    public void createJob(String login, String description, int price) {
        Job job = Job.builder()
                .description(description)
                .jobStatus(JobStatus.LOOKING_FOR.name())
                .sumOfTransaction(price)
                .transactionStatus(TransactionStatus.FREEZE.name())
                .account(accountRepository.findByLogin(login))
                .build();
        jobRepository.save(job);
    }

    public List<JobCreatorDto> findAll() {
        List<JobCreatorDto> jobCreatorDtos = new ArrayList<>();
        List<Job> jobs = jobRepository.findAll();
        for (Job job : jobs) {
            jobCreatorDtos.add(JobCreatorDto
                    .builder()
                    .login(job.getAccount().getLogin())
                    .description(job.getDescription())
                    .price(job.getSumOfTransaction())
                    .jobId(job.getJobId())
                    .build());
        }
        return jobCreatorDtos;
    }
}
