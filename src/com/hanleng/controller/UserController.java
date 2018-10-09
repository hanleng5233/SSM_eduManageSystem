package com.hanleng.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanleng.entity.Student;
import com.hanleng.entity.Teacher;
import com.hanleng.entity.User;
import com.hanleng.service.StudentService;
import com.hanleng.service.TeacherService;
import com.hanleng.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/login")
	public String login(String name, String password, String usertype, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		// 管理员身份登录
		if ("1".equals(usertype)) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setId(1);
			User loginUser = userService.userlogin(user);
			if (loginUser != null) {
				session.setAttribute("user", loginUser);
				return "homepage/index";
			} else {
				model.addAttribute("msg", "请输入正确的用户名和密码");
				return "/index";
			}
		}
		// 学生身份登录
		if ("2".equals(usertype)) {
			Student student = new Student();
			student.setLoginname(name);
			student.setPassword(password);
			Student studentLogin = studentService.stulogin(student);
			if (studentLogin != null) {
				session.setAttribute("user", studentLogin);
				return "homepage/index";
			} else {
				model.addAttribute("msg", "请输入正确的用户名和密码");
				return "/index";
			}
		}
		// 教师身份登录
		if ("3".equals(usertype)) {
			Teacher teacher = new Teacher();
			teacher.setLoginname(name);
			teacher.setPassword(password);
			Teacher teacherLogin = teacherService.loginTea(teacher);
			if (teacherLogin != null) {
				session.setAttribute("user", teacherLogin);
				return "homepage/index";
			} else {
				model.addAttribute("msg", "请输入正确的用户名和密码");
				return "/index";
			}
		}
		return "/index";
	}

	@RequestMapping("loginout")
	public void loginout(HttpSession session) {
		session.removeAttribute("user");
	}
}
