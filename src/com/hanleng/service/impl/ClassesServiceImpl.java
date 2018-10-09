package com.hanleng.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanleng.entity.Classes;
import com.hanleng.mapper.ClassesMapper;
import com.hanleng.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public List<Classes> getAllClasses() {
		return classesMapper.getAllClasses();
	}

	@Override
	public List<Classes> getClassPager(int pageNO, int size) {
		int skip = (pageNO - 1) * size;
		return classesMapper.getClassPager(skip, size);
	}

	@Override
	public Classes getCLassId(int id) {
		return classesMapper.getCLassId(id);
	}

	@Override
	public int getClassesCount() {
		return classesMapper.getClassesCount();
	}

	@Override
	public int insert(Classes entity) {
		return classesMapper.insert(entity);
	}

	@Override
	public int delete(int id) {
		int row = classesMapper.delete(id);
		return row;
	}

	@Override
	public int deletes(int[] ids) {
		int rows = 0;
		for (int id : ids) {
			rows += delete(id);
		}
		return rows;
	}

	@Override
	public int update(Classes entity) {
		return classesMapper.update(entity);
	}

	@Override
	public Classes getStuByid(int id) {
		return classesMapper.getStuByid(id);
	}
}
