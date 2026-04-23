package com.Ankitha.College.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ankitha.College.dto.StudentDto;
import com.Ankitha.College.entity.Student;
import com.Ankitha.College.exception.ResourceNotFoundException;
import com.Ankitha.College.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	
	
	public Student insert(StudentDto dto)
	{
		
		Student s= new Student();
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		s.setAddress(dto.getAddress());
		
		
		return repo.save(s);
	}
   public List<Student> getAllStudent()
   {
	   return repo.findAll();
   }
   
   public Student getById(Long id )
   {
	   return repo.findById(id)
			   .orElseThrow(()-> new ResourceNotFoundException("student not found : " +id));
   }
   public String delete()
   {
	    repo.deleteAll();
	    return "deeleted successfully";
   }
   public String deleteByid(Long id)
   {
	   repo.deleteById(id);
	   return "deleted successfully";
   }
   
   
}
