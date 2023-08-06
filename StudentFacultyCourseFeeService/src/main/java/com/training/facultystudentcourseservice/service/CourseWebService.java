package com.training.facultystudentcourseservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.facultystudentcourseservice.model.Course;

@FeignClient("COURSESERVICE")
public interface CourseWebService {
	
	@GetMapping("/courses")
	public List<Course> getAllCourses();
	
	@GetMapping(value = "/{courseId}")//course/courseId
	public Course getOnecourseById(@PathVariable(value = "courseId") Long courseId);
	
	@PostMapping("/course")
	public Course createCourse(@RequestBody Course course);
	
	@PutMapping("/course")
	public boolean updateCourse(Course course);
	
	@DeleteMapping(value = "/{courseId}")
	public boolean deleteCourseById(@PathVariable(value = "courseId") Long courseId);
	
	
	
}