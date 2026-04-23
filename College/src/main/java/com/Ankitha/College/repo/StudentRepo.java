package com.Ankitha.College.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ankitha.College.entity.Student;

@Repository
public interface StudentRepo  extends JpaRepository<Student,Long>{

	

	

}
