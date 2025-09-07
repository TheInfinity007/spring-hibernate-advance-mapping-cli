package com.github.theinfinity007.hibernate_advance_cli;

import com.github.theinfinity007.hibernate_advance_cli.dao.AppDAO;
import com.github.theinfinity007.hibernate_advance_cli.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateAdvanceCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAdvanceCliApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				createInstructor(appDAO);
//				deleteInstructor(appDAO);

//				findInstructorDetail(appDAO);
//				deleteInstructorDetail(appDAO);

//				createInstructorWithCourses(appDAO);

//				findInstructorWithCourses(appDAO);

//				findCoursesForInstructor(appDAO);

//				findInstructorWithCoursesJoinFetch(appDAO);

//				updateInstructor(appDAO);

//				updateCourse(appDAO);

//				deleteCourse(appDAO);

//				createCourseAndReviews(appDAO);

//				retrieveCourseAndReviews(appDAO);

//				deleteCourseAndReviews(appDAO);

				// Many to many started
//				createCourseAndStudents(appDAO);

//				findCourseAndStudents(appDAO);

//				findStudentAndCourses(appDAO);

//				addMoreCoursesToStudent(appDAO);

//				deleteCourse(appDAO);

				deleteStudent(appDAO);
			}
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int studentId = 19;

		System.out.println("Deleting student with id " + studentId);

		appDAO.deleteStudentById(studentId);

		System.out.println("Done!");
	}

	private void addMoreCoursesToStudent(AppDAO appDAO) {
		int studentId = 19;

		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);

		Course course1 = new Course("Rubik's cube - How to speed cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating student " + student);
		System.out.println("Associated courses Before " + student.getCourses());

		appDAO.update(student);
		System.out.println("Associated courses After " + student.getCourses());

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int studentId = 19;

		System.out.println("Fetching student with id " + studentId);

		Student student = appDAO.findStudentAndCoursesByStudentId(studentId);
		System.out.println("student = " + student);

		System.out.println("courses = " + student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int courseId = 14;

		System.out.println("Fetching the course with id " + courseId);

		Course course = appDAO.findCourseAndStudentsByCourseId(courseId);

		System.out.println("Course = "  + course);
		System.out.println("Students = " + course.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		System.out.println("Creating course and students");

		Course course = new Course("Pacman - How to score one Million Points");

		Student student1 = new Student("John", "Doe", "john@yopmail.com");
		Student student2 = new Student("Mary", "Public", "mary@yopmail.com");

		course.add(student1);
		course.add(student2);

		System.out.println("Saving the course" + course);
		appDAO.save(course);

		System.out.println("course = " + course);
		System.out.println("students = " + course.getStudents());

		System.out.println("Done");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int courseId = 13;

		System.out.println("Deleting course with id " + courseId);

		appDAO.deleteCourseById(courseId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int courseId = 13;

		System.out.println("Fetching course with review with course id " + courseId);
		Course course = appDAO.findCourseAndReviewByCourseId(courseId);

		System.out.println("course = " + course);
		System.out.println("Reviews = " + course.getReviews());
		System.out.println("Done");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pac - How to score One Million Points");

		course.add(new Review("Great course.... loved it!"));
		course.add(new Review("Cool course, job well done."));
		course.add(new Review("What a dumb course, you are an idiot!"));

		System.out.println("Saving the course with its reviews");
		appDAO.save(course);
		System.out.println("Saved");
		System.out.println(course);
		System.out.println(course.getReviews());
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 14;
		System.out.println("Deleting course with id " + id);

		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;


		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course with id " + id);

		course.setTitle("Air Guitar - The Ultimate Guide");
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {


		Instructor instructor = createInstructor(appDAO);
		int id = instructor.getId();
		System.out.println("Updating instructor with id "  + id);

		instructor.setFirstName("new first name");
		instructor.setLastName("new last name");

		appDAO.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 5;
		System.out.println("Finding instructor with id using JoinFetch " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("instructor = " + instructor);
		System.out.println("Associated courses = " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 5;
		System.out.println("Finding instructor with id " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor = " + instructor);

		System.out.println("Finding courses for instructor with id " + id);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("associated courses" + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 5;

		System.out.println("Finding instructor with id " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor = " + instructor);

		System.out.println("associated courses" + instructor.getCourses());
		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Create instructor
		Instructor instructor = new Instructor("Chad", "Darby", "darby@yopmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Create courses in Java");

		instructor.setInstructorDetail(instructorDetail);

		// Create some courses
		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		// Saving the instructor, it will also save the courses
		System.out.println("Saving instructor with course");
		System.out.println("instructor = " + instructor);
		System.out.println("The Courses = " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Instructor detail saved");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 4;
		System.out.println("Deleting instructor detail with id " + id);
		appDAO.deleteInstructorDetailById(id);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 3;

		System.out.println("Finding instructor detail with id " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("instructorDetail = " + instructorDetail);

//		Instructor instructor = instructorDetail.getInstructor();
//		System.out.println("instructor = " + instructor);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 5;
		System.out.println("Deleting instructor with id " + id);
		appDAO.deleteInstructorById(id);
		System.out.println("Instructor deleted with id " + id);
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;

		System.out.println("Finding instructor with id " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor = " + instructor.toString());
		System.out.println("instructor detail = " + instructor.getInstructorDetail().toString());
	}

	private Instructor createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Chad", "Darby", "darby@yopmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Create courses in Java");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor");
		System.out.println("instructor = " + instructor);
		appDAO.save(instructor);

		System.out.println("Instructor detail saved");
		return instructor;
	}
}
