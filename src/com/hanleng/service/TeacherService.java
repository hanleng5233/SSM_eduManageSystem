package com.hanleng.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hanleng.entity.Classes;
import com.hanleng.entity.Grade;
import com.hanleng.entity.Student;
import com.hanleng.entity.StudentView;
import com.hanleng.entity.Teacher;

/**
 * @author hanleng
 * @date 2018年9月30日
 * @version 1.0
 */
public interface TeacherService {

	public List<Teacher> getTeacherPager(int pageNO, int size);

	public Teacher getTeacherId(int id);

	public int getTeacherCount();

	public int insert(Teacher entity);

	public int delete(int id);

	public int update(Teacher entity);

	int deletes(int[] ids);
	
	public List<Teacher> getAllTeacher();

	public int getMyStuCount(int id);
	
	public Teacher loginTea(Teacher tea);
	
	public List<StudentView> getMystus(int tid);
	
	int insertGrade(Grade grade);
	
}
