package com.hanleng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanleng.entity.Grade;
import com.hanleng.entity.StudentView;
import com.hanleng.entity.Teacher;
import com.hanleng.mapper.GradeMapper;
import com.hanleng.mapper.TeacherMapper;
import com.hanleng.service.TeacherService;

/**
 * @author hanleng
 * @date 2018年9月30日
 * @version 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	// 自动装配
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public int deletes(int[] ids) {
		int rows = 0;
		for (int id : ids) {
			rows += delete(id);
		}
		return rows;
	}

	@Override
	public List<Teacher> getTeacherPager(int pageNO, int size) {
		int skip = (pageNO - 1) * size;
		return teacherMapper.getTeacherPager(skip, size);
	}

	@Override
	public Teacher getTeacherId(int id) {
		return teacherMapper.getTeacherId(id);
	}

	@Override
	public int getTeacherCount() {
		return teacherMapper.getTeacherCount();
	}

	@Override
	public int insert(Teacher entity) {
		return teacherMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		return teacherMapper.delete(id);
	}

	@Override
	public int update(Teacher entity) {
		return teacherMapper.update(entity);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherMapper.getAllTeacher();
	}

	@Override
	public Teacher loginTea(Teacher tea) {
		return teacherMapper.tealogin(tea);
	}

	@Override
	public int getMyStuCount(int id) {
		return 0;
	}

	@Override
	public List<StudentView> getMystus(int tid) {
		List<StudentView> xxslist = teacherMapper.getxxStudent(tid);
		List<StudentView> bxslist = teacherMapper.getbxStudent(tid);
		List<StudentView> slist = new ArrayList<StudentView>();
		slist.addAll(xxslist);
		slist.addAll(bxslist);
		return slist;
	}

	@Override
	public int insertGrade(Grade grade) {
		return gradeMapper.insertGrade(grade);
	}

}
