package com.abm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.abm.entity.Student;
import com.abm.repo.StudentRepository;

@Controller
public class MyController {
	
	@Autowired
	private StudentRepository studentRepository;
	@RequestMapping("/add-student")
	public String saveStudents(Student student )
	{
		studentRepository.save(student);
		return "index.jsp";
	}
	@RequestMapping("/show-student")
	public String studentAll(Map map) {
		List<Student> list=studentRepository.findAll();
		map.put("sms",list);
		return "view.jsp";

}
	
	@RequestMapping("/delete-student")
	public String delete(@RequestParam int rollNo,  Map map) {
		studentRepository.deleteById(rollNo);
	map.put("message", "Record delete Sucessfully");
	return"index.jsp";
}
@RequestMapping("/edit-student")
public String edit(@RequestParam int rollNo,  Map model) {
Student student=studentRepository.findById(rollNo).get();
model.put("student", student);
return"editStudent.jsp";



}
@RequestMapping("/update-student")
public String update(Student student, Map map) {
	studentRepository.save(student);
	map.put("message", "Record updated Sucessfully");
	return "index.jsp";
}
	
	
}
