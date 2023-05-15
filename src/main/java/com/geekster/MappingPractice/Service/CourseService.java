package com.geekster.MappingPractice.Service;

import com.geekster.MappingPractice.Model.Course;
import com.geekster.MappingPractice.Model.Student;
import com.geekster.MappingPractice.Repository.CourseRepository;
import com.geekster.MappingPractice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(String id, Course course) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setTitle(course.getTitle());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setDuration(course.getDuration());
            existingCourse.setStudentList(course.getStudentList());
            return courseRepository.save(existingCourse);
        } else {
            return null;
        }
    }

    public void enrollStudents(String courseId, List<String> studentIds) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        List<Student> students = studentRepository.findAllById(studentIds);
        if (students.size() != studentIds.size()) {
            throw new IllegalArgumentException("One or more students not found.");
        }

        List<Student> studentList = course.getStudentList();
        for (Student student : students) {
            if (!studentList.contains(student)) {
                studentList.add(student);
            }
        }

        courseRepository.save(course);
    }
    public void unenrollStudents(String courseId, List<String> studentIds) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        List<Student> students = studentRepository.findAllById(studentIds);
        if (students.size() != studentIds.size()) {
            throw new IllegalArgumentException("One or more students not found.");
        }

        List<Student> studentList = course.getStudentList();
        studentList.removeAll(students);

        courseRepository.save(course);
    }
}
