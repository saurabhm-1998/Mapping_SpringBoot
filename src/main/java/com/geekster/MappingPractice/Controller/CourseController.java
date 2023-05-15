package com.geekster.MappingPractice.Controller;

import com.geekster.MappingPractice.Model.Course;
import com.geekster.MappingPractice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Optional<Course> optionalCourse = courseService.getCourseById(id);
        if (optionalCourse.isPresent()) {
            return ResponseEntity.ok(optionalCourse.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.created(URI.create("/api/courses/" + createdCourse.getID())).body(createdCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<Void> enrollStudents(@PathVariable String courseId, @RequestBody List<String> studentIds) {
        courseService.enrollStudents(courseId, studentIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{courseId}/enroll")
    public ResponseEntity<Void> unenrollStudents(@PathVariable String courseId, @RequestBody List<String> studentIds) {
        courseService.unenrollStudents(courseId, studentIds);
        return ResponseEntity.ok().build();
    }
}
