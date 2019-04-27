package com.aviskar.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aviskar.example.model.Student;
import com.aviskar.example.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public String students(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "student-list";
	}

	@RequestMapping(path = "/add-student", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	@RequestMapping(path = "/add-student", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student) {
		studentService.save(student);
		return "redirect:/students";
	}

	@RequestMapping(path = "/edit-student", method = RequestMethod.GET)
	public String editStudent(@RequestParam Long id, Model model) {
		model.addAttribute("student", studentService.findOne(id));
		return "student-form";
	}

	@RequestMapping(path = "/edit-student", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute Student student) {
		studentService.update(student);
		return "redirect:/students";
	}

	@RequestMapping(path = "/delete-student", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam Long id) {
		studentService.delete(id);
		return "redirect:/students";
	}
}
