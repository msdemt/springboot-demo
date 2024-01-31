package org.example.demo.mapper.local;

import java.util.List;

import org.example.demo.model.local.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {

    List<StudentEntity> selectStudents();

    void setNamesLatin1();
}
