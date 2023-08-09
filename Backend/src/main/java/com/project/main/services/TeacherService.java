package com.project.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.main.model.Teacher;
import com.project.main.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;  // "teacherRepository" is the object of "TeacherService" class.
	// get all teacher
	public List<Teacher> addAllTeachers(List<Teacher> teachers) {
		return teacherRepository.saveAll(teachers);
	}
	
	// update teacher
	public Teacher updateTeacher(Teacher teacher) {
		Teacher existingTEACH = teacherRepository.findById(teacher.getId()).orElse(null);
		if(existingTEACH == null)
		{
			return teacherRepository.save(teacher);
		}
		else
		{
			teacherRepository.deleteById(existingTEACH.getId());
			teacherRepository.save(teacher);
		}
		return teacher;
	}

	// delete teacher
	public boolean deleteTeacherByID(int id) {
		Teacher existingTEACH = teacherRepository.findById(id).orElse(null);
		System.out.println(existingTEACH);
		if(existingTEACH != null)
		{
			teacherRepository.deleteById(id);
			return true;
		}
		else 
		{
		return false;
		}
	}
	
// delete teacher
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}

	public Teacher addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}

}
