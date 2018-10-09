package com.hanleng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hanleng.entity.Classes;

@Repository
public interface ClassesMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Classes record);

	int insertSelective(Classes record);

	Classes selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Classes record);

	int updateByPrimaryKey(Classes record);

	List<Classes> getAllClasses();

	public List<Classes> getClassPager(@Param("skip") int skip, @Param("size") int size);

	public Classes getCLassId(int id);

	public int getClassesCount();

	public int delete(int id);

	public int update(Classes entity);

	public Classes getStuByid(int id);

}