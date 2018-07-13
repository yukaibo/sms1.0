package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/student")
public class StudentController {
	// 注入studentService的实例
	@Autowired
	private IStudentService studentService;
	
	// http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllStudent")
	public List<Student> findAllStudent(){
		try {
			List<Student> list = studentService.findAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("findStudentById")
	public Student findStudentById(long id){
		try {
			Student student = studentService.findById(id);
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping("saveStudent")
	public void saveStudent(Student student){
		try{
			studentService.save(student);
		}catch(Exception  e){
			e.printStackTrace();
		}
	}
	@PostMapping("updatestudent")
	public void updateStudent(Student student){
		try {
			studentService.update(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PostMapping("deletestudent")
	public void deleteStudent(Student student){
		try {
			studentService.delete(student);
		} catch (Exception e) {
		     e.printStackTrace();
		}
	}
}













