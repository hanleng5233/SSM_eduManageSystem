package com.hanleng.service;

import java.util.List;

import com.hanleng.entity.CourseExt;
import com.hanleng.entity.Sc;
import com.hanleng.entity.Student;
import com.hanleng.entity.StudentExt;

public interface StudentService {
	List<Student> getStudentPager(int pageNO, int size);

	int getCount();

	int deleteByPrimaryKey(Integer id);// 删除

	int multiDelete(int[] ids);

	int insert(Student record);

	Student selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(Student record);

	public List<StudentExt> getStuByCid(int id);

	public Student stulogin(Student student);

	List<CourseExt> getXuxiu(int classid);

	int inserBatch(List<Sc> sclist);

	List<CourseExt> getMycourses(int classid, int stuid);

}
