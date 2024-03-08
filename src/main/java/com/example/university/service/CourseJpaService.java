/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.university.service;

import com.example.university.model.*;
import com.example.university.repository.*;
import com.example.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service

public class CourseJpaService implements CourseRepository {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private ProfessorJpaRepository professorJpaRepository;

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Override
    public ArrayList<Course> getCourses() {
        List<Course> courseList = courseJpaRepository.findAll();
        ArrayList<Course> courses = new ArrayList<>(courseList);
        return courses;
    }

    @Override
    public Course getCourseById(int courseId) {
        try {
            Course course = courseJpaRepository.findById(courseId).get();
            return course;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // public Course addCourse(Course course) {
    // try {
    // // int courseId = course.getCourse().getCourseId();
    // // Course course = courseJpaRepository.findById(courseId).get();

    // // if(course.getProfessor()!=null){
    // // int professorId=course.getProfessor().getProfessorId();
    // // Professor professor=professorJpaRepository.findById(professorId).get();
    // // course.setProfessor(professor);
    // // }

    // // if(course.getStudents()!=null){
    // // List<Integer> studentIds = new ArrayList<>();
    // // for (Student student : course.getStudents()) {
    // // studentIds.add(student.getStudentId());
    // // }
    // // List<Student> students = studentJpaRepository.findAllById(studentIds);
    // // for (Student student : students) {
    // // student.getCourses().add(course);
    // // }
    // // studentJpaRepository.saveAll(students);
    // // course.setStudents(students);
    // // }

    // return courseJpaRepository.save(course);
    // } catch (Exception e) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    // }
    // }

    // @Override
    // public Course addCourse(Course course) {
    // try {
    // int professorId = course.getProfessor().getProfessorId();
    // // Professor professor = ProfessorJpaService.getProfessorById(professorId);
    // Professor professor = professorJpaRepository.findById(professorId).get();
    // course.setProfessor(professor);

    // List<Integer> studentIds = new ArrayList<>();
    // for (Student student : course.getStudents()) {
    // studentIds.add(student.getStudentId());
    // }

    // List<Student> students = studentJpaRepository.findAllById(studentIds);
    // course.setStudents(students);

    // return courseJpaRepository.save(course);
    // } catch (Exception e) {
    // throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    // }
    // }

    @Override
    public Course addCourse(Course course) {
        int professorId = course.getProfessor().getProfessorId();
        Professor professor = professorJpaRepository.findById(professorId).get();
        course.setProfessor(professor);

        List<Integer> studentIds = new ArrayList<>();
        for (Student student : course.getStudents()) {
            studentIds.add(student.getStudentId());
        }

        List<Student> students = studentJpaRepository.findAllById(studentIds);
        course.setStudents(students);

        return courseJpaRepository.save(course);
    }

    @Override
    public Course updateCourse(int courseId, Course course) {
        try {
            Course newCourse = courseJpaRepository.findById(courseId).get();
            if (course.getCourseName() != null) {
                newCourse.setCourseName(course.getCourseName());
            }
            if (course.getCredits() != null) {
                newCourse.setCredits(course.getCredits());
            }
            if (course.getProfessor() != null) {
                int professorId = course.getProfessor().getProfessorId();
                Professor newProfessor = professorJpaRepository.findById(professorId).get();
                newCourse.setProfessor(newProfessor);
            }
            if (course.getStudents() != null) {
                List<Student> students = newCourse.getStudents();
                for (Student student : students) {
                    student.getCourses().remove(newCourse);
                }
                studentJpaRepository.saveAll(students);
                List<Integer> newStudentIds = new ArrayList<>();
                for (Student student : course.getStudents()) {
                    newStudentIds.add(student.getStudentId());
                }
                List<Student> newStudents = studentJpaRepository.findAllById(newStudentIds);
                for (Student student : newStudents) {
                    student.getCourses().add(newCourse);
                }
                studentJpaRepository.saveAll(newStudents);
                newCourse.setStudents(newStudents);
            }
            return courseJpaRepository.save(newCourse);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        try {
            courseJpaRepository.deleteById(courseId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Professor getCourseProfessors(int courseId) {
        try {
            Course course = courseJpaRepository.findById(courseId).get();
            return course.getProfessor();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Student> getCourseStudents(int courseId) {
        try {
            Course course = courseJpaRepository.findById(courseId).get();
            return course.getStudents();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
