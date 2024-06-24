package com.demo.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.jpa.Student;
import com.demo.jpa.controller.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository repo;
	
	@RequestMapping("home")
	public String home()
	{
		return "home.jsp";
	}
	
//	@RequestMapping("/addStudent")
//	public String addStudent(Student student) {
//		repo.save(student);
//		return "add.jsp";
//	}
//	
//	@RequestMapping("fetchStudent")
//	public ModelAndView fetchstudent(@RequestParam("id") int id)
//	{
//		Student student= repo.findById(id).orElse(new Student());
//		ModelAndView mv = new ModelAndView("fetch.jsp");
//		mv.addObject("student", student);
//		return mv;
//
//	}
//	@RequestMapping("/updateStudent")
//	public String updateStudent(@RequestParam("id") int id,Student student)
//	{
//		repo.save(student);
//		return "update.jsp";
//	}
//	 
//	@RequestMapping("/deleteStudent")
//	public String deleteStudent(@RequestParam("id") int id)
//	{
//		repo.deleteById(id);
//		return "delete.jsp";
//	}
	
	
	
	//Rest API response in string format
	//fetching all students
	
//	 @RequestMapping("/students")
//	@ResponseBody
//	public String getStudents()
//	{
//		return repo.findAll().toString();
//	
//	}	
//	@RequestMapping("/students/{id}")
//	@ResponseBody
//	public String getStudents(@PathVariable("id") int id)
//	{
//		return repo.findById(id).toString();
//	
//	}	
	
	
	//Rest API JSON format
//	@RequestMapping("/students")
//	@ResponseBody
//	public List<Student> getStudents()
//	{
//		return repo.findAll();
//	
//	}	
//	@RequestMapping("/students/{id}")
//	@ResponseBody
//	public Optional getStudents(@PathVariable("id") int id)
//	{
//		return repo.findById(id);
//	
//	}
	
	//postman api  //restcontroller
	@PostMapping("/student")
	public Student addStud(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}
	@GetMapping("/student/{id}")
	public Optional<Student> fetchStudent(@PathVariable("id") int id){
		return repo.findById(id);
	}
	
	@PutMapping("/student")
	public Student updateStud(@RequestBody Student student)
	{
		repo.save(student);
		return student;
	}
	@DeleteMapping("/student/{id}")
	public String deleteStud(@PathVariable("id") int id)
	{
		Student student = repo.getOne(id);
		
		repo.delete(student);
		return "Deleted Successfully";
	}
}
