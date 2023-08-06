package com.training.facultystudentcourseservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.facultystudentcourseservice.model.Fee;



@FeignClient("FEESERVICE")
public interface FeeWebService {
	
	@GetMapping(value = "/fee/student/{studentId}")
	public Fee getFeeByStudentId(@PathVariable(value="studentId") long studentId);
	
	@PostMapping(value = "/fee")
	public Fee createFee(@RequestBody Fee fee);
	
	@PutMapping("/updatefee")
	public boolean updateFee(@RequestBody Fee fee);
	
	@DeleteMapping(value = "/{feeId}")
	public boolean deleteFeeByStudentId(@PathVariable(value="feeId") Long feeId);
	
	

}
