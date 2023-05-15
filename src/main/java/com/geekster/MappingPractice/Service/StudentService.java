package com.geekster.MappingPractice.Service;

import com.geekster.MappingPractice.Model.Student;
import com.geekster.MappingPractice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(String id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(student.getName());
            existingStudent.setAge(student.getAge());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setBranch(student.getBranch());
            existingStudent.setDepartment(student.getDepartment());
            existingStudent.setAddress(student.getAddress());
            return studentRepository.save(existingStudent);
        } else {
            return null;
        }
    }
}
