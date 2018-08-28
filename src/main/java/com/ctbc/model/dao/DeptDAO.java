package com.ctbc.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctbc.model.vo.DeptVO;

@Repository
public class DeptDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DeptVO> getAll(){
		Session currentSession = sessionFactory.getCurrentSession();
		List<DeptVO> deptList = currentSession.createQuery("from DeptVO", DeptVO.class).list();
		return deptList;
	}
	
}




