package com.hanleng.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanleng.entity.CourseExt;
import com.hanleng.entity.Sc;
import com.hanleng.entity.Student;
import com.hanleng.entity.StudentExt;
import com.hanleng.mapper.ScMapper;
import com.hanleng.mapper.StudentMapper;
import com.hanleng.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private ScMapper scMapper;

	@Override
	public List<Student> getStudentPager(int pageNO, int size) {
		int skip = (pageNO - 1) * size;
		return studentMapper.getStudentPager(skip, size);
	}

	@Override
	public int getCount() {
		return studentMapper.getCount();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int multiDelete(int[] ids) {
		int rows = 0;
		for (int id : ids) {
			rows += deleteByPrimaryKey(id);
		}
		return rows;
	}

	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<StudentExt> getStuByCid(int id) {
		return studentMapper.getStuByCid(id);
	}

	@Override
	public Student stulogin(Student student) {
		return studentMapper.stulogin(student);
	}

	@Override
	public List<CourseExt> getXuxiu(int classid) {
		return studentMapper.getXuxiu(classid);
	}

	@Override
	public int inserBatch(List<Sc> sclist) {
		return scMapper.inserBatch(sclist);
	}

	@Override
	public List<CourseExt> getMycourses(int classid, int stuid) {
		List<CourseExt> bxlist = studentMapper.getBxCourse(classid);
		List<CourseExt> xxlist = studentMapper.getxxCourse(stuid);
		List<CourseExt> ctlist = new ArrayList<CourseExt>();
		ctlist.addAll(bxlist);
		ctlist.addAll(xxlist);
		return ctlist;
	}
}
