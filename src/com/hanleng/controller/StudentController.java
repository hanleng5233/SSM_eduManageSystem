package com.hanleng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanleng.entity.Classes;
import com.hanleng.entity.CourseExt;
import com.hanleng.entity.Sc;
import com.hanleng.entity.Student;
import com.hanleng.service.ClassesService;
import com.hanleng.service.StudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ClassesService classesService;

	@RequestMapping("/list")
	public String getlist(@RequestParam(required = false, defaultValue = "1") int pageNO, Model model) {
		int size = 3;
		List<Student> slist = studentService.getStudentPager(pageNO, size);
		model.addAttribute("pageNO", pageNO);
		model.addAttribute("size", size);
		model.addAttribute("count", studentService.getCount());
		model.addAttribute("slist", slist);
		return "student/list";
	}

	// 重定向一定要写绝对路径eg:redirect:/stu/list
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @RequestParam(required = false, defaultValue = "1") int pageNO, RedirectAttributes redirectAttributes) {
		int rows = studentService.deleteByPrimaryKey(id);
		if (rows > 0) {
			redirectAttributes.addFlashAttribute("message", "成功删除！");
		} else {
			redirectAttributes.addFlashAttribute("message", "删除失败！");
		}
		return "redirect:/stu/list?pageNO"+ pageNO;
	}

	@RequestMapping("/deletes")
	public String deletes(@RequestParam("id") int[] ids, Model model, RedirectAttributes redirectAttributes) {
		int rows = 0;
		rows = studentService.multiDelete(ids);
		if (rows > 0) {
			redirectAttributes.addFlashAttribute("message", "成功删除！");
		} else {
			redirectAttributes.addFlashAttribute("message", "删除shibai！");
		}
		return "redirect:/stu/list";
	}

	// 查询所有的班级，添加学生时选择学生所在相应的班级
	@RequestMapping("/add")
	public String add(Model model) {
		List<Classes> clist = classesService.getAllClasses();
		model.addAttribute("clist", clist);
		model.addAttribute("entity", new Student());
		return "student/add";
	}

	//
	@RequestMapping("/addSave")
	public String addSave(Model model, @ModelAttribute("entity") @Valid Student entity, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("entity", entity);
			List<Classes> clist = classesService.getAllClasses();
			model.addAttribute("clist", clist);
			return "student/add";
		} else {
			List<Classes> clist = classesService.getAllClasses();
			model.addAttribute("clist", clist);
			model.addAttribute("entity", new Student());
			entity.setUsertype(2);
			studentService.insert(entity);
			return "redirect:/stu/list";
		}

	}

	@RequestMapping("/edit/{id}")
	public String add(Model model, @PathVariable int id) {
		List<Classes> clist = classesService.getAllClasses();
		model.addAttribute("clist", clist);
		model.addAttribute("entity", studentService.selectByPrimaryKey(id));
		return "student/edit";
	}

	//
	@RequestMapping("/editSave")
	public String editSave(Model model, Student student) {
		studentService.updateByPrimaryKey(student);
		return "redirect:/stu/list";
	}

	@RequestMapping("/getXuXiu")
	public String getXuXiu(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Student student = (Student) session.getAttribute("user");
		List<CourseExt> clist = studentService.getXuxiu(student.getClassid());
		model.addAttribute("colist", clist);
		return "student/colist";
	}

	@RequestMapping(value = "/semycou", produces = "text/html;charset=utf8")
	@ResponseBody
	public String semycou(@RequestParam("cou") String[] ct, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Student student = (Student) session.getAttribute("user");
		List<Sc> sclist = new ArrayList<Sc>();
		for (int i = 0; i < ct.length; i++) {
			Sc sc = new Sc();
			String cteveryone = ct[i];
			String[] ctarray = cteveryone.split("_");
			sc.setCid(Integer.parseInt(ctarray[0]));
			sc.setTid(Integer.parseInt(ctarray[1]));
			sc.setSid(student.getId());
			sclist.add(sc);
		}
		String msg = "";
		try {
			studentService.inserBatch(sclist);
			msg = "选课成功！";
		} catch (Exception e) {
			msg = "选课可能有重复，请审核后重试！";
		}
		return msg;
	}

	@RequestMapping("/getStuCourse")
	public String getStuCourse(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Student student = (Student) session.getAttribute("user");
		List<CourseExt> ctlist = studentService.getMycourses(student.getClassid(), student.getId());
		model.addAttribute("ctlist", ctlist);
		return "student/cslist";
	}
}
