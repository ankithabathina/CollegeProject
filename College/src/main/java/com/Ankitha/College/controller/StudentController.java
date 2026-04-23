package com.Ankitha.College.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ankitha.College.dto.StudentDto;
import com.Ankitha.College.entity.Student;
import com.Ankitha.College.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public Student add(@Valid @RequestBody StudentDto dto)
	{
		return service.insert(dto);
	}
	@GetMapping("/get")
	public List<Student> get()
	{
		return service.getAllStudent();
	}
   @GetMapping("/{id}")
   public Student getAllById(@PathVariable Long id)
   {
	   return service.getById(id);
   }
   @DeleteMapping("/delete")
   public String deleteAll()
   {
	   service.delete();
	   return "deleted Successfully";
   }
   @DeleteMapping("/{id}")
   public String deletebyId(@PathVariable Long id)
   {
	   service.deleteByid(id);
	   return "deleted successfully";
	   
   }
  
}
