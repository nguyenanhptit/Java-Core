package com.thuannd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.thuannd.dao.Student;
import com.thuannd.dao.StudentDAO;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/student/list";
	}

	// add and update
	@RequestMapping(value = "/student/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Student student, ModelMap model) {
		studentDAO.createTableIfNotExist();
		if (student.getId() > 0) {
			studentDAO.updateStudent(student);
		} else {
			studentDAO.insert(student);
		}
		model.addAttribute("student", student);
		return new ModelAndView("redirect:/student/list", model);
	}

	// hien form add
	@RequestMapping(value = "/student/form", method = RequestMethod.GET)
	public ModelAndView studentForm(Student student, ModelMap model) {
		model.addAttribute("student", new Student());
		return new ModelAndView("student.save", model);
	}

	// hien list
	@RequestMapping(value = "/student/list", method = RequestMethod.GET)
	public ModelAndView listStudent(@RequestParam(value = "q", required = false) String query) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student.list");
		mv.addObject("students", studentDAO.listStudent());
		return mv;
	}

	// search
	@RequestMapping(value = "/student/search", method = RequestMethod.GET)
	public ModelAndView searchStudent(@RequestParam(value = "q", required = false) String keyword) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("students", studentDAO.searchStudent(keyword));
		mv.setViewName("student.list");
		return mv;
	}

	// xoa
	@GetMapping(value = "/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentDAO.deleteStudent(id);
		return "redirect:/student/list";
	}

	// hien form edit
	@RequestMapping(value = "/student/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable("id") int id, ModelMap model) {
		Student student = studentDAO.getStudentById(id);
		model.addAttribute("student", student);
		return new ModelAndView("student.save", model);
	}

	// luu edit
	@PostMapping(value = "/student/edit/save")
	public String saveEdit(Model model, @ModelAttribute("student") Student student) {
		studentDAO.updateStudent(student);
		return "redirect:/student/list";
	}

	// detail
	@RequestMapping(value = "/student/json/{id}", method = RequestMethod.GET)
	public @ResponseBody Student viewJson(@PathVariable("id") int id) {
		return studentDAO.getStudentById(id);
	}

	// upload file
	@RequestMapping(value = "/student/avatar/save", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "student.error";
		}
		try {
			byte[] bytes = file.getBytes();
			System.out.println("found: " + bytes.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/student/list";
	}

}
