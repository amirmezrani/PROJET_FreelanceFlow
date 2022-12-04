package com.example.proj_profess.controller;

import com.example.proj_profess.entity.Job;
import com.example.proj_profess.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/{idProvider}/add")
    public Job jobSignup (@PathVariable Long idProvider,@RequestBody Job job){
        return jobService.addJob(idProvider,job);
    }

    @GetMapping("/getJob/{idJob}")
    public Job getJobById(@PathVariable Long idJob){
        return jobService.getJobById(idJob);
    }

    @GetMapping("/{idProvider}/getAllJob")
    public List<Job> getAllJob(@PathVariable Long idProvider){
        return jobService.getAllJob(idProvider);
    }

    @PutMapping("/editJob/{idJob}")
    public Job editJob (@PathVariable Long idJob, @RequestBody Job job ){
        return jobService.editJob(idJob,job);
    }

    @DeleteMapping("deleteJob/{idJob}")
    public ResponseEntity<?> deleteJob (@PathVariable Long idJob){
        return jobService.deleteJob(idJob);
    }

}
