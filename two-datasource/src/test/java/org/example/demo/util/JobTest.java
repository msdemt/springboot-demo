package org.example.demo.util;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.example.demo.mapper.local.StudentMapper;
import org.example.demo.mapper.slurm.JobMapper;
import org.example.demo.model.local.StudentEntity;
import org.example.demo.model.slurm.JobEntity;

@SpringBootTest
public class JobTest {

    @Resource
    private JobMapper jobMapper;

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void test() {
        jobMapper.setNamesLatin1();
        List<JobEntity> jobEntities = jobMapper.selectJobEntity();
        System.out.println(jobEntities);
    }

    @Test
    public void testStudent() {
        jobMapper.setNamesLatin1();
        List<StudentEntity> studentEntities = studentMapper.selectStudents();
        System.out.println(studentEntities);
    }
}
