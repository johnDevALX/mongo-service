package net.ekene.mongoservice.service;

import lombok.RequiredArgsConstructor;
import net.ekene.mongoservice.model.Student;
import net.ekene.mongoservice.repository.StudentRepository;
import net.ekene.mongoservice.utility.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(StudentDTO student) {
        Student student1 = Student.builder()
                .studentId(student.getStudentId())
                .email(student.getEmail())
                .password(student.getPassword())
                .build();
        return studentRepository.save(student1);
    }

    @Override
    public Student getStudent(String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.orElse(null);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
