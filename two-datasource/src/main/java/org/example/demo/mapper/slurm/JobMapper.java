package org.example.demo.mapper.slurm;

import java.util.List;

import org.example.demo.model.slurm.JobEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface JobMapper {

    List<JobEntity> selectJobEntity();

    void setNamesLatin1();
}
