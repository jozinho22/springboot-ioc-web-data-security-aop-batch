package com.douineau.controller.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoadController {

    @Autowired
    JobLauncher joblauncher;

    @Autowired
    Job job;

    @GetMapping("/load")
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> map = new HashMap<>();
        map.put("time", new JobParameter(System.currentTimeMillis()));

        JobParameters param = new JobParameters(map);
        JobExecution exec = joblauncher.run(job, param);

        System.out.println("Execution status : " + exec.getStatus());

        while(exec.isRunning()) {
            System.out.println("Batch is running...");
        }

        return exec.getStatus();
    }
}
