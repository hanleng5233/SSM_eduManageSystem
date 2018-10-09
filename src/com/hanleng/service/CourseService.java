package com.hanleng.service;

import java.util.List;

import com.hanleng.entity.Course;
import com.hanleng.entity.CtcKey;
/**
 * @author hanleng
 * @date 2018年9月30日
 * @version 1.0
 */
public interface CourseService {

	public List<Course> getCoursePager(int pageNO, int size);

	public Course getCourseId(int id);

	public int getCourseCount();

	public int insert(Course entity);

	public int delete(int id);

	public int update(Course entity);

	int deletes(int[] ids);
	
	void  insertBatch(List<CtcKey> ctclist);
	
	//public List<CourseExt> getMyCourse(int id);

}
