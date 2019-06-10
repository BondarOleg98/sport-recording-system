package com.olegb.service.Service.Contracts;
import com.olegb.service.Model.Student;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IStudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student, Map<String, String> artCoach);
    Student OneStudent(UUID id);
    Student replaceStudent(Student newStudent, UUID id, Map<String, String> artCoach);
    Map<String, Boolean> deleteStudent(UUID id);
}
