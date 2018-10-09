package com.hanleng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanleng.entity.Course;
import com.hanleng.entity.CtcKey;
import com.hanleng.mapper.CourseMapper;
import com.hanleng.mapper.CtcMapper;
import com.hanleng.service.CourseService;

/**
 * @author hanleng
 * @date 2018年9月30日
 * @version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {

	// 自动装配
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private CtcMapper ctcMapper;

	@Override
	public int deletes(int[] ids) {
		int rows = 0;
		for (int id : ids) {
			rows += delete(id);
		}
		return rows;
	}

	@Override
	public List<Course> getCoursePager(int pageNO, int size) {
		int skip = (pageNO - 1) * size;
		return courseMapper.getCoursePager(skip, size);
	}

	@Override
	public Course getCourseId(int id) {
		// TODO Auto-generated method stub
		return courseMapper.getCourseId(id);
	}

	@Override
	public int getCourseCount() {
		// TODO Auto-generated method stub
		return courseMapper.getCourseCount();
	}

	@Override
	public int insert(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return courseMapper.delete(id);
	}

	@Override
	public int update(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.update(entity);
	}

	@Override
	public void insertBatch(List<CtcKey> ctclist) {
		// TODO Auto-generated method stub
		ctcMapper.insertBatch(ctclist);
	}
}
