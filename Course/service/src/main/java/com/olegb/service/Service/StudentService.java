package com.olegb.service.Service;

import com.olegb.service.Controller.NotFoundException;
import com.olegb.service.Model.Student;
import com.olegb.service.Repository.StudentRepository;
import com.olegb.service.Service.Contracts.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CoachService coachService;

    @Autowired
    private ArtService artService;


    @Override
    public List<Student> getAllStudents(){
        List<Student> Students = studentRepository.findAll();
        return Students;
    }

    @Override
    public Student createStudent(Student student, Map<String,String> artCoach){
        String keyCoach = artCoach.get("indCoach");
        String keyArt = artCoach.get("indArt");
        if(keyArt!=null){
            student.setArtStyle(artService.OneArt(UUID.fromString(keyArt)));
        }
        if(keyCoach!=null){
            student.setCoach(coachService.OneCoach(UUID.fromString(keyCoach)));
        }
        UUID uuid = UUID.randomUUID();
        student.setId(uuid);
        return studentRepository.save(student);

    }

    @Override
    public Student OneStudent(UUID id) {
        return  studentRepository.findById(id).orElseThrow(() -> new NotFoundException("student", id));
    }

    @Override
    public Student replaceStudent(Student newStudent, UUID id, Map<String,String>artCoach) {
        String keyCoach = artCoach.get("indCoach");
        String keyArt = artCoach.get("indArt");
        return studentRepository.findById(id)
                    .map(student -> {
                        if(keyArt!=null){
                            student.setArtStyle(artService.OneArt(UUID.fromString(keyArt)));
                        }
                        else {
                            student.setArtStyle(null);
                        }
                        if(keyCoach!=null){
                            student.setCoach(coachService.OneCoach(UUID.fromString(keyCoach)));
                        }
                        else {
                            student.setCoach(null);
                        }
                        student.setName(newStudent.getName());
                        student.setSurname(newStudent.getSurname());
                        student.setAge(newStudent.getAge());
                        student.setCountWins(newStudent.getCountWins());
                        return studentRepository.save(student);
                    })
                    .orElseGet(() -> {
                        newStudent.setId(id);
                        return studentRepository.save(newStudent);
                    });
    }

    @Override
    public Map<String, Boolean> deleteStudent(UUID id) {
        Map<String, Boolean>response = new HashMap<>();
        if(!studentRepository.findById(id).isPresent()){
            response.put("Error 404: student not found",Boolean.FALSE);
            return response;
        } else {
            studentRepository.deleteById(id);
            response.put("Boolean",Boolean.TRUE);
            return response;
        }
    }
}
