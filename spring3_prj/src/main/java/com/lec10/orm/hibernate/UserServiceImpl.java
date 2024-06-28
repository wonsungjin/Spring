package com.lec10.orm.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SessionFactory sessionFactory;
//	public UserImpl(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	@Transactional
	public List<UserVO> list() {
		@SuppressWarnings("unchecked") //ignore generic type compile warning
		List<UserVO> list = (List<UserVO>)sessionFactory.getCurrentSession()
														.createCriteria(UserVO.class)
														.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}
	

}
