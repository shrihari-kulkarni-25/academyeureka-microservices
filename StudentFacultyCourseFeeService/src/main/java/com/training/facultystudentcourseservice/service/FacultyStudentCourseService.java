package com.training.facultystudentcourseservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.facultystudentcourseservice.model.Course;

public interface FacultyStudentCourseService {

	public List<Course> getCourses();
	public Course addCourseFaculty(Course course);
	public boolean updateCourseFaculty(Course course);
	public boolean deleteFacultyById(Long facultyId);
	public Course getCourseById(Long courseId);
	
}