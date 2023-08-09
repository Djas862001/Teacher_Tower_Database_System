package com.project.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.main.model.Teacher;
import com.project.main.services.TeacherService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/teach")
public class TeacherController {

	@Autowired
	private TeacherService teacherService; 
	
	
	//Add new Teacher
	@PostMapping("/addTeacher")
	public Teacher addTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.addTeacher(teacher);		
	}
	
	//Add more than one new Teachers
	@PostMapping("/addTeachers")
	public List<Teacher> addAllTeachers(@RequestBody List<Teacher> teachers)
	{
		return teacherService.addAllTeachers(teachers);		
	}
	
	
	
	
	//Get All Teachers details
		@GetMapping("/teachers")
		public List<Teacher> getTeachers()
		{
			return teacherService.getTeachers();
			
		}
	
	// Update teacher
	@PutMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher)
	{
		return teacherService.updateTeacher(teacher);		
	}
	
	// delete teacher
	@DeleteMapping("/deleteTeacherById/{id}")
	public boolean deleteTeacherById(@PathVariable int id)
	{
			return teacherService.deleteTeacherByID(id);	
		
	}
	
}
