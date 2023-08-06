package com.training.facultystudentcourseservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.facultystudentcourseservice.config.DataNotFoundException;
import com.training.facultystudentcourseservice.config.ServiceDownException;
import com.training.facultystudentcourseservice.model.Course;
import com.training.facultystudentcourseservice.service.FacultyStudentCourseService;

import feign.RetryableException;

@RestController
public class FacultyStudentCourseController {

	@Autowired
	FacultyStudentCourseService facStudentCourseService;

	@GetMapping("/courses")
	public List<Course> getCourses() {
		return facStudentCourseService.getCourses();
	}

	@GetMapping(value = "/{courseId}")
	public Course getCourseById(@PathVariable(value = "courseId") Long courseId) {
		try {
			return facStudentCourseService.getCourseById(courseId);
		}
		catch(feign.FeignException e) {
			throw new DataNotFoundException();
		}
		
		
	}

	@PostMapping("/faculty")
	public ResponseEntity createFaculty(@Valid @RequestBody Course course, BindingResult result) {

		Map<String, String> errors = new HashMap<String, String>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});

			// LOGGER.info("Error occurred in the request body:" + errors);
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(facStudentCourseService.addCourseFaculty(course), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateFaculty(@Valid @RequestBody Course course, BindingResult result) {

		Map<String, String> errors = new HashMap<String, String>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});

			//LOGGER.info("Error occurred in the request body:" + errors);
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		else if(facStudentCourseService.updateCourseFaculty(course) == true) {
		   return new ResponseEntity<>("Details updated successfully", HttpStatus.CREATED);
		}
		else {
			throw new DataNotFoundException();
		}
	


	}

	@DeleteMapping(value = "/{facultyId}")
	public String deleteFacultyById(@PathVariable(value = "facultyId") Long facultyId) {
		try {
			if (facStudentCourseService.deleteFacultyById(facultyId)== true) {
				return "Deleted Successfully";
			}
			else {
				return "ID Not Found in Databse, Try again with different ID";
			}
		} catch (feign.RetryableException e) {
			throw new ServiceDownException();
		}
		
	}

}