package com.github.theinfinity007.hibernate_advance_cli.dao;

import com.github.theinfinity007.hibernate_advance_cli.entity.Course;
import com.github.theinfinity007.hibernate_advance_cli.entity.Instructor;
import com.github.theinfinity007.hibernate_advance_cli.entity.InstructorDetail;
import com.github.theinfinity007.hibernate_advance_cli.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);
}
