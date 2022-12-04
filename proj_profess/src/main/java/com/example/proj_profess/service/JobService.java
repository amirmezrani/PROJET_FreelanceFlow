package com.example.proj_profess.service;

import com.example.proj_profess.entity.Job;
import com.example.proj_profess.entity.Provider;
import com.example.proj_profess.repository.JobRepo;
import com.example.proj_profess.repository.ProviderRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {

    private JobRepo jobRepo;

    private ProviderService providerService;

    public Job getJobById (Long idJob){
        return  jobRepo.findById(idJob).orElseThrow(()-> new IllegalArgumentException("Job ID not Found"));
    }

    public List<Job> getAllJob(Long idProvider){
        return jobRepo.findByProviderId(idProvider);
    }

    public Job addJob(Long idProvider,Job job){
        Provider provider=providerService.getProviderById(idProvider);
        //provider.getJobList().add(job);
        job.setProvider(provider);
        job = jobRepo.save(job);
        return job;
    }

    public Job editJob(Long idJob ,Job job){
        Job job1 = getJobById(idJob);
        job1.setTitle(job.getTitle());
        job1.setDescription(job.getDescription());
        return jobRepo.save(job1);

    }

    public ResponseEntity<?> deleteJob (Long idJob){
        jobRepo.deleteById(idJob);
        return ResponseEntity.ok().build();
    }
}
